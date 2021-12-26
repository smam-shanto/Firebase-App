package com.earnsmart.myapp;

public class Transaction {
    public String username, tid ;
    public Transaction(){

    }

    public Transaction( String username, String tid){

        this.username=username;
        this.tid=tid;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }
}
