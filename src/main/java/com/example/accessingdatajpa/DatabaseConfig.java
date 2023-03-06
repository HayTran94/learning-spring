package com.example.accessingdatajpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Bean("mysql")
    public MysqlConnector generateMysqlConnect() {
        return new MysqlConnector("123");
    }

    @Bean("mongodb")
    public MongoDBConnector generateMongoDBConnect() {
        return new MongoDBConnector("456");
    }
}
