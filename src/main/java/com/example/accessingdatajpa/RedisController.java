package com.example.accessingdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    CacheConnector cacheConnector;

    @PostMapping("/redis/set")
    public String set(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value ) {
        return this.cacheConnector.Set(key, value);
    }

    @GetMapping("/redis/get")
    public String get(@RequestParam(value = "key") String key) {
        return this.cacheConnector.Get(key);
    }
}
