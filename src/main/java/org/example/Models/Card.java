package org.example.Models;

import java.time.LocalDateTime;

public class Card extends Transaction {

    private String merchantId;
    private String merchantName; //equivalente a nome fantasia
    private String cardType;
    private String cardNumber;
    private String cvv;

    public Card(String merchantId, String merchantName,
                String cardType, String cardNumber,
                String cvv, double value, LocalDateTime dateTime,
                String state, String incricaoBeneficiario){

    super(value, dateTime, state, incricaoBeneficiario);
    this.merchantId = merchantId;
    this.merchantName = merchantName;
    this.cardType = cardType;
    this.cardNumber = cardNumber;
    this.cvv = cvv;
    setType("Cartão de "+cardType);

    }

    public Card(String merchantId, String merchantName,
                String cardType, String cardNumber,
                String cvv,
                double value, LocalDateTime dateTime,
                String incricaoBeneficiario){

        super(value, dateTime, incricaoBeneficiario);
        this.merchantId = merchantId;
        this.merchantName = merchantName;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        setType("Cartão de "+cardType);

    }

    public String toString() {
        return "Card{" +
                "merchantId='" + merchantId + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cvv='" + cvv + '\'' +
                ", value=" + getValue() +
                ", dateTime=" + getDateTime() +
                ", locale=" + getState()+
                ", incricaoBeneficiario='" + getIncricaoBeneficiado()+ '\'' +
                ", type='" + getType() + '\'' +
                '}';
    }

    //Getter e setters
    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
