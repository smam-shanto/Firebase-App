package com.earnsmart.myapp;

public class Team {
    public String name, username, position, refer, rank, password;

    public Team(){

    }
    public Team( String name, String username, String position, String refer, String rank, String password){
        this.name = name;
        this.username = username;
        this.position = position;
        this.refer = refer;
        this.rank = rank;
        this.password=password;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
