package com.bsuir.cardealership.controller;

import com.bsuir.cardealership.model.DateSlots;
import com.bsuir.cardealership.payload.request.DateSlotsRequest;
import com.bsuir.cardealership.repository.DateSlotsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DateSlotsController {
    @Autowired
    DateSlotsRepository dateSlotsRepository;

    @GetMapping("/slots")
    public ResponseEntity<List<DateSlots>> getAllSlots() {
        try {

            List<DateSlots> dateSlots = new ArrayList<DateSlots>(dateSlotsRepository.findAll());

            if (dateSlots.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(dateSlots, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/slots")
    public ResponseEntity<DateSlots> createDateSlots(@RequestBody DateSlotsRequest dateSlots) {
//        try {
            DateSlots _tutorial = dateSlotsRepository
                    .save(new DateSlots(dateSlots.getDate()));
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }
}
