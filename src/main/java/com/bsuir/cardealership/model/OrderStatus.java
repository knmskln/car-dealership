package com.bsuir.cardealership.model;

import javax.persistence.*;

@Entity
@Table(name = "statuses")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EOrderStatus name;

    public OrderStatus() {

    }

    public OrderStatus(EOrderStatus name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EOrderStatus getName() {
        return name;
    }

    public void setName(EOrderStatus name) {
        this.name = name;
    }
}