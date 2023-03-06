package com.example.accessingdatajpa;

public class MongoDBConnector extends DatabaseConnector{
    public MongoDBConnector(String addr) {
        this.addr = addr;
    }
    @Override
    public String connect() {
        return "connect mongodb to " + this.addr;
    }
}
