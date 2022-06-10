package com.machinecoding.digitalWallet.entity;

public class AccountHolder {
    String name;
    Double balance;
    Integer numberOfTransaction;
    String lastTransactionType;
    Double lastTransactionAmount;
    Integer accountOpeningTime;

    public AccountHolder(String name, Double balance, Integer numberOfTransaction, String lastTransactionType, Double lastTransactionAmount, Integer accountOpeningTime) {
        this.name = name;
        this.balance = balance;
        this.numberOfTransaction = numberOfTransaction;
        this.lastTransactionType = lastTransactionType;
        this.lastTransactionAmount = lastTransactionAmount;
        this.accountOpeningTime = accountOpeningTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getNumberOfTransaction() {
        return numberOfTransaction;
    }

    public void setNumberOfTransaction(Integer numberOfTransaction) {
        this.numberOfTransaction = numberOfTransaction;
    }

    public String getLastTransactionType() {
        return lastTransactionType;
    }

    public void setLastTransactionType(String lastTransactionType) {
        this.lastTransactionType = lastTransactionType;
    }

    public Double getLastTransactionAmount() {
        return lastTransactionAmount;
    }

    public void setLastTransactionAmount(Double lastTransactionAmount) {
        this.lastTransactionAmount = lastTransactionAmount;
    }

    public Integer getAccountOpeningTime() {
        return accountOpeningTime;
    }

    public void setAccountOpeningTime(Integer accountOpeningTime) {
        this.accountOpeningTime = accountOpeningTime;
    }
}
