package org.example;

import org.example.Models.Card;
import org.example.Models.Conta;
import org.example.Models.Transaction;
import org.example.Repository.TransactionRepository;
import org.example.Service.TransactionAnalysisService;
import org.example.Service.ValueValidatorService;
import org.example.Service.GeoValidatorService;
import org.example.Service.TimeValidatorService;

import java.time.LocalDateTime;
import java.time.Duration;
import java.util.OptionalDouble;

public class Main2 {
    public static void main(String[] args) {

        TransactionRepository tr = new TransactionRepository();
        Conta contaDoCliente = tr.conta;

        TransactionAnalysisService analysisService = new TransactionAnalysisService();

        System.out.println("--- Início dos Testes de Detecção de Fraude ---");

        // --- Configuração dos dados de referência ---
        Transaction ultimaTransacao = (Transaction) contaDoCliente.getTransacoes().stream().map(t->(Transaction) t).toList().getLast();
        double mediaMensal = ValueValidatorService.averageDailyLastMonth(contaDoCliente.getTransacoes()).orElse(0.0);

        System.out.println("\n--- Dados de Referência do Cliente ---");
        System.out.println("Média de valor mensal: R$ " + String.format("%.2f", mediaMensal));
        System.out.println("Última transação registrada:");
        System.out.println("  - Data e Hora: " + ultimaTransacao.getDateTime());
        System.out.println("  - Localização: " + ultimaTransacao.getState());
        System.out.println("  - Valor: R$ " + String.format("%.2f", ultimaTransacao.getValue()));

        // --- Teste 1: Transação Normal ---
        System.out.println("\n--- Teste 1: Transação Normal");
        Transaction transacaoNormal = new Card("5555", "Loja do Zé", "Débito", "1234567890123456", "111",
                50.00, LocalDateTime.now(), "SP", "Beneficiário Loja do Zé");

        System.out.println("Analisando nova transação:");
        System.out.println("  - Data e Hora: " + transacaoNormal.getDateTime());
        System.out.println("  - Localização: " + transacaoNormal.getState());
        System.out.println("  - Valor: R$ " + String.format("%.2f", transacaoNormal.getValue()));

        int scoreNormal = analysisService.analyzeRisk(transacaoNormal, contaDoCliente);
        System.out.println("Score de Risco: " + scoreNormal + " (Esperado: 0)");
        System.out.println("Status: " + (scoreNormal > 0 ? "Possível Risco" : "OK"));

        // --- Teste 2: Transação de Alto Valor (Anomalia de Padrão) ---
        System.out.println("\n--- Teste 2: Alto Valor (Anomalia de Padrão)");
        Transaction transacaoValorAlto = new Card("9999", "Viagens Inc.", "Crédito", "1111222233334444", "222",
                15000.00, LocalDateTime.now(), "SP", "Beneficiário Viagens");

        System.out.println("Analisando nova transação:");
        System.out.println("  - Data e Hora: " + transacaoValorAlto.getDateTime());
        System.out.println("  - Localização: " + transacaoValorAlto.getState());
        System.out.println("  - Valor: R$ " + String.format("%.2f", transacaoValorAlto.getValue()));

        int scoreValorAlto = analysisService.analyzeRisk(transacaoValorAlto, contaDoCliente);
        System.out.println("Score de Risco: " + scoreValorAlto + " (Esperado: 3 ou mais)");
        System.out.println("Status: " + (scoreValorAlto > 0 ? "Possível Risco" : "OK"));

        // --- Teste 3: Transação em Horário de Risco ---
        System.out.println("\n--- Teste 3: Horário de Risco (Noturno)");
        Transaction transacaoRiscoTempo = new Card("6666", "Farmácia", "Débito", "9876543210987654", "333",
                75.00, LocalDateTime.of(2025, 9, 18, 23, 0), "SP", "Beneficiário Farmácia");

        System.out.println("Analisando nova transação:");
        System.out.println("  - Data e Hora: " + transacaoRiscoTempo.getDateTime());
        System.out.println("  - Localização: " + transacaoRiscoTempo.getState());
        System.out.println("  - Valor: R$ " + String.format("%.2f", transacaoRiscoTempo.getValue()));

        int scoreRiscoTempo = analysisService.analyzeRisk(transacaoRiscoTempo, contaDoCliente);
        System.out.println("Score de Risco: " + scoreRiscoTempo + " (Esperado: 2 ou mais)");
        System.out.println("Status: " + (scoreRiscoTempo > 0 ? "Possível Risco" : "OK"));

        // --- Teste 4: Transação Geograficamente Impossível ---
        System.out.println("\n--- Teste 4: Transação Impossível (SC -> AL)");

        // Adicionando uma transação para simular a última transação em SC.
        contaDoCliente.addTransacation(new Card("7777", "Bar da Esquina", "Débito", "1234567890123456", "444",
                30.00, LocalDateTime.of(2025, 9, 18, 17, 0), "SC", "Beneficiário Bar"));

        // Nova transação em um estado distante, apenas 10 minutos depois.
        Transaction transacaoImpossivel = new Card("8888", "Loja de Vinhos", "Crédito", "1111222233334444", "555",
                150.00, LocalDateTime.of(2025, 9, 18, 17, 10), "AL", "Beneficiário Vinhos");

        // Obtendo as distâncias e tempos para exibição
        GeoUtils geoUtils = new GeoUtils();
        Double distanciaKm = GeoValidatorService.calcDistance(transacaoImpossivel, geoUtils.getLatLon(), contaDoCliente.getTransacoes());
        Duration tempoMinimoViagem = GeoValidatorService.minimumTIme(distanciaKm);


        System.out.println("Analisando nova transação:");
        System.out.println("  - Data e Hora: " + transacaoImpossivel.getDateTime());
        System.out.println("  - Localização: " + transacaoImpossivel.getState());
        System.out.println("  - Valor: R$ " + String.format("%.2f", transacaoImpossivel.getValue()));
        System.out.println("  - Última transação registrada: " + ultimaTransacao.getState());
        System.out.println("  - Distância entre as transações: " + String.format("%.2f", distanciaKm) + " km");
        System.out.println("  - Tempo mínimo de viagem estimado: " + tempoMinimoViagem.toHours() + "h " + (tempoMinimoViagem.toMinutes() % 60) + "m");

        int scoreImpossivel = analysisService.analyzeRisk(transacaoImpossivel, contaDoCliente);
        System.out.println("Score de Risco: " + scoreImpossivel + " (Esperado: 8 ou mais)");
        System.out.println("Status: " + (scoreImpossivel > 0 ? "Possível Risco (ALTO)" : "OK"));

        System.out.println("\n--- Fim dos Testes ---");
    }
}