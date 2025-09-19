package org.example.Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pix extends Transaction {

    private String chaveDestino;
    private String cpfDestino;
    private String numeroAgenciaDestino;
    private String numeroContaDestino;
    //private String compeDestino; ???



    public Pix(double value, LocalDateTime dateTime, String state,
               String chaveDestino, String cpfDestino, String numeroAgenciaDestino, String numeroContaDestino,
               String incricaoBeneficiario){
        super(value, dateTime, state, incricaoBeneficiario);
        this.chaveDestino = chaveDestino;
        this.cpfDestino = cpfDestino;
        this.numeroAgenciaDestino = numeroAgenciaDestino;
        this.numeroContaDestino = numeroContaDestino;
        setType("Pix");
    }

    //Contrutor sem o locale
    public Pix(double value, LocalDateTime dateTime,
               String chaveDestino, String cpfDestino, String numeroAgenciaDestino, String numeroContaDestino,
               String incricaoBeneficiario){
        super(value, dateTime, incricaoBeneficiario);
        this.chaveDestino = chaveDestino;
        this.cpfDestino = cpfDestino;
        this.numeroAgenciaDestino = numeroAgenciaDestino;
        this.numeroContaDestino = numeroContaDestino;
        setType("Pix");
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return "Pix{" +
                "chaveDestino='" + chaveDestino + '\'' +
                ", cpfDestino='" + cpfDestino + '\'' +
                ", numeroAgenciaDestino='" + numeroAgenciaDestino + '\'' +
                ", numeroContaDestino='" + numeroContaDestino + '\'' +
                ", value=" + getValue() +
                ", dateTime=" + getDateTime().format(formatter) +
                ", locale=" + getState() +
                ", incricaoBeneficiario='" + getIncricaoBeneficiado() + '\'' +
                ", type='" + getType() + '\'' +
                '}';
    }



    public String getChaveDestino() {
        return chaveDestino;
    }

    public void setChaveDestino(String chaveDestino) {
        this.chaveDestino = chaveDestino;
    }

    public String getCpfDestino() {
        return cpfDestino;
    }

    public void setCpfDestino(String cpfDestino) {
        this.cpfDestino = cpfDestino;
    }

    public String getNumeroAgenciaDestino() {
        return numeroAgenciaDestino;
    }

    public void setNumeroAgenciaDestino(String numeroAgenciaDestino) {
        this.numeroAgenciaDestino = numeroAgenciaDestino;
    }

    public String getNumeroContaDestino() {
        return numeroContaDestino;
    }

    public void setNumeroContaDestino(String numeroContaDestino) {
        this.numeroContaDestino = numeroContaDestino;
    }
}
