package com.bsuir.cardealership.repository;

import com.bsuir.cardealership.model.DateSlots;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateSlotsRepository extends JpaRepository<DateSlots, Long> {
    DateSlots getDateSlotsById(Long dateSlotsId);
}
