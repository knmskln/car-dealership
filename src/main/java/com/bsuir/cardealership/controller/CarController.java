package com.bsuir.cardealership.controller;

import com.bsuir.cardealership.model.Car;
import com.bsuir.cardealership.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    CarRepository carRepository;

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars(@RequestParam(required = false) String mark) {

        try {
            List<Car> cars = new ArrayList<Car>();

            if (mark == null)
                carRepository.findAll().forEach(cars::add);
            else
                carRepository.findByMarkContaining(mark).forEach(cars::add);

            if (cars.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(cars, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") long id) {
        Optional<Car> carData = carRepository.findById(id);

        if (carData.isPresent()) {
            return new ResponseEntity<>(carData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/cars")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        try {
            Car _tutorial = carRepository
                    .save(new Car(car.getMark(), car.getModel(), car.getYear(), car.getColor(), car.getPrice()));
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/cars/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Car> updateCar(@PathVariable("id") long id, @RequestBody Car car) {
        Optional<Car> carData = carRepository.findById(id);
        if (carData.isPresent()) {
            Car _car = carData.get();
            _car.setMark(car.getMark());
            _car.setModel(car.getModel());
            _car.setYear(car.getYear());
            _car.setColor(car.getColor());
            _car.setPrice(car.getPrice());
            return new ResponseEntity<>(carRepository.save(_car), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/cars/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable("id") long id) {
        try {
            carRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/cars")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> deleteAllCars() {
        try {
            carRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
