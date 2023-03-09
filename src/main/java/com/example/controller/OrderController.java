package com.example.controller;

import com.example.model.Order;
import com.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    public OrderRepository orderRepository;

    @GetMapping("/order/byuserid")
    // http://localhost:8080/order/byuserid?id=123
    public List<Order> getByUserId(@RequestParam("id") Integer id) {
        return orderRepository.findByUserId(id);
    }

    @GetMapping("/order/byuseridordered")
    // http://localhost:8080/order/byuseridordered?id=123
    public List<Order> getByUserIdOrdered(@RequestParam("id") Integer id) {
        return orderRepository.findByUserIdOrderByItemIdDesc(id);
    }

    @GetMapping("/order/byitemid")
    // http://localhost:8080/order/byitemid?id=1001
    public List<Order> getByItemId(@RequestParam("id") Integer id) {
        return orderRepository.findByItemId(id);
    }

    @GetMapping("/order/byuseridanditemid")
    // http://localhost:8080/order/byuseridanditemid?uid=123&iid=201
    public List<Order> getByUserIdAndItemId(@RequestParam("uid") Integer uid, @RequestParam("iid") Integer iid) {
        return orderRepository.findByUserIdAndItemId(uid, iid);
    }

}
