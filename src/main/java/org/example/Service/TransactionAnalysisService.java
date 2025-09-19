package org.example.Service;

import org.example.GeoUtils;
import org.example.Models.Conta;
import org.example.Models.Transaction;
import java.time.Duration;

public class TransactionAnalysisService {

    private final TimeValidatorService timeValidatorService;
    private final GeoValidatorService geoValidatorService;
    private final ValueValidatorService valueValidatorService;
    private final GeoUtils geoUtils;

    public TransactionAnalysisService() {
        this.timeValidatorService = new TimeValidatorService();
        this.geoValidatorService = new GeoValidatorService();
        this.valueValidatorService = new ValueValidatorService();
        this.geoUtils = new GeoUtils();
    }

    /**
     * Analisa uma nova transação e retorna um score de risco.
     * @param novaTransacao A nova transação a ser avaliada.
     * @param conta A conta do cliente com o histórico de transações.
     * @return Um score de risco de 0 a 10.
     */
    public int analyzeRisk(Transaction novaTransacao, Conta conta) {
        int score = 0;

        // 1. Validação de Padrão de Valor
        double averageDaily = valueValidatorService.averageDailyLastMonth(conta.getTransacoes()).orElse(0.0);
        if (novaTransacao.getValue() > averageDaily * 2) { // Exemplo: valor mais que o dobro da média
            score += 3; // Risco moderado
        }
        if (novaTransacao.getValue() > averageDaily * 5) {
            score += 5; // Risco alto
        }

        // 2. Validação de Horário de Risco (Noturno)
        if (timeValidatorService.isRiskTime(novaTransacao)) {
            score += 2; // Adiciona um risco por transação noturna
        }

        // 3. Validação Geográfica e de Tempo entre Transações
        if (conta.getTransacoes() != null && !conta.getTransacoes().isEmpty() && novaTransacao.getState() != null) {
            Duration periodoEntreTransacoes = timeValidatorService.periodBetweenTransaction(conta.getTransacoes(), novaTransacao);
            Double distanciaKm = geoValidatorService.calcDistance(novaTransacao, geoUtils.getLatLon(), conta.getTransacoes());
            Duration tempoMinimoViagem = geoValidatorService.minimumTIme(distanciaKm);

            if (periodoEntreTransacoes.compareTo(tempoMinimoViagem) < 0) {
                // Se o tempo da transação for menor que o tempo mínimo de viagem
                score += 8; // Gravíssimo, adiciona um alto score
            }
        }

        // Limita o score máximo para evitar overflow
        return Math.min(10, score);
    }
}