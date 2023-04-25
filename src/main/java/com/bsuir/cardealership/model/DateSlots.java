package com.bsuir.cardealership.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "date_slots")
public class DateSlots {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "date")
    private LocalDateTime date;

    public DateSlots(LocalDateTime date) {
        this.date = date;
    }

    public DateSlots() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}