package org.example.Service;

import org.example.Models.Transaction;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class ValueValidatorService {

    public static OptionalDouble last24h(ArrayList<Transaction> transactions) {

        List<Transaction> transacDia = transactions.stream()
                .filter(t -> LocalDate.of(t.getDateTime().getYear(), t.getDateTime().getMonth(), t.getDateTime().getDayOfMonth()).equals(LocalDate.now()))
                .collect(Collectors.toList());

        return transacDia.stream().map(t -> t.getValue()).mapToDouble(t -> t).average();

    }


    //CGPT
    public static OptionalDouble averageDailyLastMonth(List<Transaction> transactions) {
        LocalDate hoje = LocalDate.now();
        LocalDate inicioMes = hoje.minusMonths(1);

        // Filtrar transações do último mês
        Map<LocalDate, List<Transaction>> porDia = transactions.stream()
                .filter(t -> !t.getDateTime().toLocalDate().isBefore(inicioMes))
                .collect(Collectors.groupingBy(t -> t.getDateTime().toLocalDate()));

        // Calcular média de cada dia
        List<Double> mediasDiarias = porDia.values().stream()
                .map(lista -> lista.stream()
                        .mapToDouble(Transaction::getValue)
                        .average()
                        .orElse(0.0))
                .collect(Collectors.toList());

        // Média das médias diárias
        return mediasDiarias.stream()
                .mapToDouble(Double::doubleValue)
                .average();
    }


    //CGPT
    public static OptionalDouble averageDailyLastYear(List<Transaction> transactions) {
        LocalDate hoje = LocalDate.now();
        LocalDate inicioAno = hoje.minusYears(1);

        // Filtrar transações do último ano
        Map<LocalDate, List<Transaction>> porDia = transactions.stream()
                .filter(t -> !t.getDateTime().toLocalDate().isBefore(inicioAno))
                .collect(Collectors.groupingBy(t -> t.getDateTime().toLocalDate()));

        // Calcular média de cada dia
        List<Double> mediasDiarias = porDia.values().stream()
                .map(lista -> lista.stream()
                        .mapToDouble(Transaction::getValue)
                        .average()
                        .orElse(0.0))
                .collect(Collectors.toList());

        // Média das médias diárias (baseline anual)
        return mediasDiarias.stream()
                .mapToDouble(Double::doubleValue)
                .average();
    }


}
