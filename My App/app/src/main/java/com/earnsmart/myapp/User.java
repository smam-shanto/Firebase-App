package com.earnsmart.myapp;

public class User {
    public String name, username, password, refer, rank;
    public User(){

    }
    public User(String name, String username, String password, String refer, String rank){
        this.name=name;
        this.username=username;
        this.password=password;
        this.refer=refer;
        this.rank=rank;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
