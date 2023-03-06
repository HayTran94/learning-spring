package com.example.accessingdatajpa;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RedisConnector implements CacheConnector{
    Map<String, String> maps = new HashMap<>();
    public RedisConnector() {
        maps.put("hello", "world");
    }

    @Override
    public String Set(String key, String value) {
        return maps.put(key, value);
    }

    @Override
    public String Get(String key) {
        return maps.get(key);
    }
}
