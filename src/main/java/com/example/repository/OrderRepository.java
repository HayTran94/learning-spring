package com.example.repository;

import com.example.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserId(Integer id);

    List<Order> findByItemId(Integer id);

    List<Order> findByUserIdAndItemId(Integer uId, Integer iid);

    List<Order> findByUserIdOrderByItemIdDesc(Integer id);
}
