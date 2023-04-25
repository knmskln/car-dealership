package com.bsuir.cardealership.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car carId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "time")
    private String time;

    @ManyToOne
    @JoinColumn(name = "dealerCenter")
    private DealerCenter dealerCenter;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private OrderStatus statusId;

    public long getId() {
        return id;
    }

    public Car getCarId() {
        return carId;
    }

    public void setCarId(Car carId) {
        this.carId = carId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public DealerCenter getDealerCenter() {
        return dealerCenter;
    }

    public void setDealerCenter(DealerCenter dealerCenter) {
        this.dealerCenter = dealerCenter;
    }

    public OrderStatus getStatusId() {
        return statusId;
    }

    public void setStatusId(OrderStatus statusId) {
        this.statusId = statusId;
    }

    public Order(Car carId, User userId, String time, DealerCenter dealerCenter, OrderStatus statusId) {
        this.carId = carId;
        this.userId = userId;
        this.time = time;
        this.dealerCenter = dealerCenter;
        this.statusId = statusId;
    }

    public Order(){

    }

}
