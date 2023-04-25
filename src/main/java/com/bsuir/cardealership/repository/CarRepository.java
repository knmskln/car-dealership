package com.bsuir.cardealership.repository;

import com.bsuir.cardealership.model.Car;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByMarkContaining(String mark);

    Car getCarById(Long carId);

}
