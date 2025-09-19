package org.example.Repository;

import org.example.Models.Card;
import org.example.Models.Conta;
import org.example.Models.Pix;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class TransactionRepository {

    public Conta conta = new Conta("123654", "12574",
            "Luan", LocalDate.of(2025, 07, 29), "014");

    public TransactionRepository() {

        conta.addTransacation(new Pix(
                25.00, LocalDateTime.now(),
                "lojinha@pix.com", "11122233344",
                "0002", "11111-9", "Lojinha da Esquina"));

        conta.addTransacation(new Pix(
                320.75, LocalDateTime.now(),
                "fulano@pix.com", "98765432100",
                "0001", "98765-4", "Fulano de Tal"
        ));

        conta.addTransacation(new Card(
                "9999", "Mercado Central",
                "Débito", "4444333322221111",
                "456", 180.00, LocalDateTime.now(),
                "SP", "Beneficiário Mercado"
        ));
        // Transações Pix
        conta.addTransacation(new Pix(
                50.00, LocalDateTime.now().minusDays(1),
                "mercado@pix.com", "12345678900",
                "0001", "12345-6", "Supermercado Central"));

        conta.addTransacation(new Pix(
                1500.00, LocalDateTime.now().minusHours(5),
                "empresa@pix.com", "98765432199",
                "0002", "54321-0", "Empresa XYZ"));

        conta.addTransacation(new Pix(
                75.25, LocalDateTime.now().minusDays(2),
                "amigos@pix.com", "11122233388",
                "0003", "67890-1", "Restaurante Amigos"));

// Transações com Cartão
        conta.addTransacation(new Card(
                "1111", "Loja de Roupas",
                "Crédito", "5555666677778888",
                "123", 320.50, LocalDateTime.now().minusDays(3),
                "RJ", "Beneficiário Loja de Roupas"));

        conta.addTransacation(new Card(
                "2222", "Supermercado Central",
                "Débito", "9999000011112222",
                "456", 180.75, LocalDateTime.now().minusHours(10),
                "SP", "Beneficiário Supermercado"));

        conta.addTransacation(new Card(
                "3333", "Padaria do Bairro",
                "Crédito", "4444333322221111",
                "789", 25.90, LocalDateTime.now().minusDays(1),
                "MG", "Beneficiário Padaria"));


// Transações Pix com datas específicas
        conta.addTransacation(new Pix(
                50.00, LocalDateTime.of(2025, 9, 10, 14, 30),
                "mercado@pix.com", "12345678900",
                "0001", "12345-6", "Supermercado Central"));

        conta.addTransacation(new Pix(
                1500.00, LocalDateTime.of(2025, 9, 12, 9, 15),
                "empresa@pix.com", "98765432199",
                "0002", "54321-0", "Empresa XYZ"));

        conta.addTransacation(new Pix(
                75.25, LocalDateTime.of(2025, 9, 11, 19, 45),
                "amigos@pix.com", "11122233388",
                "0003", "67890-1", "Restaurante Amigos"));

// Transações com Cartão com datas específicas
        conta.addTransacation(new Card(
                "1111", "Loja de Roupas",
                "Crédito", "5555666677778888",
                "123", 320.50, LocalDateTime.of(2025, 9, 9, 16, 0),
                "RJ", "Beneficiário Loja de Roupas"));

        conta.addTransacation(new Card(
                "2222", "Supermercado Central",
                "Débito", "9999000011112222",
                "456", 180.75, LocalDateTime.of(2025, 9, 12, 11, 30),
                "SP", "Beneficiário Supermercado"));

        conta.addTransacation(new Card(
                "3333", "Padaria do Bairro",
                "Crédito", "4444333322221111",
                "789", 25.90, LocalDateTime.of(2025, 9, 18, 20, 55),
                "BA", "Beneficiário Padaria"));

    }
}
