package com.example.accessingdatajpa;

public class MysqlConnector extends DatabaseConnector{
    public MysqlConnector(String addr) {
        this.addr = addr;
    }

    @Override
    public String connect() {
        return "connect mysql to " + this.addr;
    }
}
