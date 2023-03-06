package com.example.accessingdatajpa;

public interface CacheConnector {
    String Set(String key, String value);
    String Get(String key);
}
