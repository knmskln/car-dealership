package com.bsuir.cardealership.repository;

import com.bsuir.cardealership.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {

}