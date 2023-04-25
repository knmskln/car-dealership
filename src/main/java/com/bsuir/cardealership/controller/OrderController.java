package com.bsuir.cardealership.controller;

import com.bsuir.cardealership.model.*;
import com.bsuir.cardealership.payload.request.OrderRequest;
import com.bsuir.cardealership.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderStatusRepository orderStatusRepository;
    @Autowired
    DealerCenterRepository dealerCenterRepository;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllCenters() {

        try {
            List<Order> orders = new ArrayList<Order>(orderRepository.findAll());

            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> createCar(@RequestBody OrderRequest orderRequest) {
        try {
            Long carId = orderRequest.getCarId();
            Long userId = orderRequest.getUserId();
            Long statusId = orderRequest.getStatusId();
            Long dealerCenterId = orderRequest.getDealerCenterId();
            Car car = carRepository.getCarById(carId);
            User user = userRepository.findUserById(userId);
            OrderStatus status = orderStatusRepository.getOrderStatusById(statusId);
            DealerCenter dealerCenter = dealerCenterRepository.getDealerCenterById(dealerCenterId);
            Order _tutorial = orderRepository
                    .save(new Order(car, user, orderRequest.getTime(), dealerCenter, status));
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
