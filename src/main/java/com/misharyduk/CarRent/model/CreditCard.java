package com.misharyduk.CarRent.model;

public class CreditCard {
    private int numberOfCard;
    private int expMonth;
    private int expYear;
    private String bankSystem;

    public int getNumberOfCard() {
        return numberOfCard;
    }

    public void setNumberOfCard(int numberOfCard) {
        this.numberOfCard = numberOfCard;
    }

    public int getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(int expMonth) {
        this.expMonth = expMonth;
    }

    public int getExpYear() {
        return expYear;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }

    public String getBankSystem() {
        return bankSystem;
    }

    public void setBankSystem(String bankSystem) {
        this.bankSystem = bankSystem;
    }
}
