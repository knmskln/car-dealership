package com.bsuir.cardealership.repository;

import com.bsuir.cardealership.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByMarkContaining(String mark);
}
