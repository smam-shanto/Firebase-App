package com.earnsmart.myapp;

public class Withdraw {
    public String username, account, amount;

    public Withdraw(){

    }

    public Withdraw(String username, String account, String amount){
        this.username = username;
        this.account = account;
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
