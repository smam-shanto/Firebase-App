package com.earnsmart.myapp;

public class Fund {
    public String username, password, amount;
    public Fund(){

    }

    public Fund(String username, String password, String amount){
        this.username = username;
        this.password = password;
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
