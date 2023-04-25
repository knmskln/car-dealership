package com.bsuir.cardealership.repository;

import com.bsuir.cardealership.model.Order;
import com.bsuir.cardealership.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {
    OrderStatus getOrderStatusById(Long statusId);
}
