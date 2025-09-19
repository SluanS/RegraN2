package org.example.Models;

import java.time.LocalDateTime;

public abstract class Transaction {

    private String type;
    private double value;
    private LocalDateTime dateTime;
    private String state;
    private String incricaoBeneficiado;
    private String status = "Em análise";

    public Transaction(double value, LocalDateTime dateTime, String state, String inscricaoBeneficiado){
        this.value = value;
        this.dateTime = dateTime;
        this.state = state;
        this.incricaoBeneficiado = inscricaoBeneficiado;
    }


    //Contrutor sem o objeto locale
    public Transaction(double value, LocalDateTime dateTime, String inscricaoBeneficiado){
        this.value = value;
        this.dateTime = dateTime;
        this.incricaoBeneficiado = inscricaoBeneficiado;
    }

    @Override
    public abstract String toString();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIncricaoBeneficiado() {
        return incricaoBeneficiado;
    }

    public void setIncricaoBeneficiado(String incricaoBeneficiado) {
        this.incricaoBeneficiado = incricaoBeneficiado;
    }

    //Getters e Setters
    public String getType(){return this.type;}
    public void setType(String type){this.type = type;}

    public double getValue(){return this.value;}
    public void setValue(double value){this.value = value;}

    public LocalDateTime getDateTime(){return dateTime;}
    public void setDateTime(LocalDateTime dateTime){ this.dateTime = dateTime;}

    public String getState(){return this.state;}
    public void setState(String state){this.state = state;}
}
