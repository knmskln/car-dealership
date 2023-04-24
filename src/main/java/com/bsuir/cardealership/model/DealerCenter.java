package com.bsuir.cardealership.model;

import javax.persistence.*;

@Entity
@Table(name = "center")
public class DealerCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "address")
    private String address;

    public DealerCenter() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DealerCenter(long id, String address) {
        this.id = id;
        this.address = address;
    }

    @Override
    public String toString() {
        return "DealerCenter{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
