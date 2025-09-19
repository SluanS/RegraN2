package org.example.Models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Conta <T extends Transaction>{


    private String cpfCliente;
    private String nConta;
    private String nome;
    private LocalDate dataAbertura;
    private String compe;
    private ArrayList<T> transacoes = new ArrayList<>();

    public Conta(String cpfCliente, String nConta, String nomeCliente,
                 LocalDate dataAbertura, String compe){
        this.cpfCliente = cpfCliente;
        this.nConta = nConta;
        this.nome = nomeCliente;
        this.dataAbertura = dataAbertura;
        this.compe = compe;
    }


    public void addTransacation(T newTransaction){
        this.transacoes.add(newTransaction);
    }

    public void carregarTransacoes(){
        //SQL querry

    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getnConta() {
        return nConta;
    }

    public void setnConta(String nConta) {
        this.nConta = nConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getCompe() {
        return compe;
    }

    public void setCompe(String compe) {
        this.compe = compe;
    }

    public ArrayList<T> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(ArrayList<T> transacoes) {
        this.transacoes = transacoes;
    }

}
