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
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "date")
    private DateSlots date;

    @ManyToOne
    @JoinColumn(name = "dealerCenter")
    private DealerCenter dealerCenter;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private OrderStatus status;

    @Column(name = "value")
    private Double value;

    public DateSlots getDate() {
        return date;
    }

    public void setDate(DateSlots date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DealerCenter getDealerCenter() {
        return dealerCenter;
    }

    public void setDealerCenter(DealerCenter dealerCenter) {
        this.dealerCenter = dealerCenter;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Order(Car car, User user, DateSlots date, DealerCenter dealerCenter, OrderStatus status, Double value) {
        this.car = car;
        this.user = user;
        this.date = date;
        this.dealerCenter = dealerCenter;
        this.status = status;
        this.value = value;
    }

    public Order(){
    }

}
