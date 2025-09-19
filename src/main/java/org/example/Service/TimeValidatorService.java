package org.example.Service;

import org.example.Models.Transaction;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

public class TimeValidatorService {

    public static boolean isRiskTime(Transaction novaTranacao) {

        // Define o início e fim do horário de risco
        LocalTime startRisk = LocalTime.of(20, 0);
        LocalTime endRisk = LocalTime.of(6, 0);

        // Obtém a hora da transação
        int horasDoDIa = novaTranacao.getDateTime().getHour();

        // Lógica corrigida para o horário de risco
        // Checa se a hora da transação está no período noturno, entre 20h e 6h
        if (LocalTime.of(horasDoDIa, 00).isAfter(startRisk) || LocalTime.of(horasDoDIa, 00).isBefore(endRisk)) {
            return true;
        } else {
            return false;
        }
    }



        public static Duration periodBetweenTransaction (ArrayList< Transaction > transacoes, Transaction
        nova_transacao){

            Transaction ultimaTrasac = transacoes.getLast();
            Duration duracao = Duration.between(ultimaTrasac.getDateTime(), nova_transacao.getDateTime());
            return duracao;
        }

    }