package com.bsuir.cardealership.controller;

import com.bsuir.cardealership.model.*;
import com.bsuir.cardealership.payload.request.OrderRequest;
import com.bsuir.cardealership.repository.*;
import com.bsuir.cardealership.util.email.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    DateSlotsRepository dateSlotsRepository;

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
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) {
        try {
            Long carId = orderRequest.getCarId();
            Long userId = orderRequest.getUserId();
            Long statusId = orderRequest.getStatusId();
            Long dealerCenterId = orderRequest.getDealerCenterId();
            Long dateId = orderRequest.getDateId();
            Car car = carRepository.getCarById(carId);
            User user = userRepository.findUserById(userId);
            OrderStatus status = orderStatusRepository.getOrderStatusById(statusId);
            DealerCenter dealerCenter = dealerCenterRepository.getDealerCenterById(dealerCenterId);
            DateSlots dateSlots = dateSlotsRepository.getDateSlotsById(dateId);
            Order _tutorial = orderRepository
                    .save(new Order(car, user, dateSlots, dealerCenter, status));
            EmailSender.getInstance().sendEmail(
                    user.getEmail(),
                    "Заявка на тест-драйв",
                    user.getName() + ", спасибо за заявку на тест-драйв!"+
                            "\nАвтомобиль: " + car.getModel() + "\nДилерский центр: "
                            + dealerCenter.getAddress() +
                            "\nДата и время: " + dateSlots.getDate()
            );
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
