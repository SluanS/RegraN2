package org.example;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;


import org.example.Models.Card;
import org.example.Models.Transaction;
import org.example.Repository.TransactionRepository;
import org.example.Service.GeoValidatorService;
import org.example.Service.TimeValidatorService;
import org.example.Service.ValueValidatorService;

import static java.util.Arrays.stream;


public class Main {
    public static void main(String[] args) {

        GeoUtils geoUtils = new GeoUtils();
        TransactionRepository tr = new TransactionRepository();


        //Nova transação foi realizada na bahia
        Card novaCompra = new Card("123",
                "Calçados S.A",
                "Débito",
                "159951",
                "147",
                800,
                LocalDateTime.now(),
                "SC",
                "cpf-456822133");




        //Faz a validação entre o periodo entre a transação atual e a ultima transação
        //
        //- Se o periodo for maior que 7h a validação geografica é acionada
        Duration intervalo_transacao = TimeValidatorService.periodBetweenTransaction(tr.conta.getTransacoes(),novaCompra);
        if(intervalo_transacao.compareTo(Duration.ofHours(7)) <= 0){

                System.out.println("Inciando validação de transação");
                Double distance = GeoValidatorService.calcDistance(novaCompra, geoUtils.latLon, tr.conta.getTransacoes());
                System.out.println("Validando periodo entre transações: ");
                Duration minimumTime = GeoValidatorService.minimumTIme(distance);
                if (intervalo_transacao.compareTo(minimumTime) < 0){
                    System.out.println("Gravissimo");
                }


            System.out.println("Meu método de calculo entre distancias");
            System.out.println(distance);


            System.out.println("Meu método que mostra o tempo ideal entre transações: ");
            System.out.println(GeoValidatorService.minimumTIme(distance));

            System.out.println(ValueValidatorService.last24h(tr.conta.getTransacoes()));

            System.out.println("Media diaria do ultimo mes");
            System.out.println(ValueValidatorService.averageDailyLastMonth(tr.conta.getTransacoes()));






        }
    }
}