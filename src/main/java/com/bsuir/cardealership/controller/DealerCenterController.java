package com.bsuir.cardealership.controller;

import com.bsuir.cardealership.model.DealerCenter;
import com.bsuir.cardealership.repository.DealerCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DealerCenterController {
    @Autowired
    DealerCenterRepository dealerCenterRepository;

    @GetMapping("/centers")
    public ResponseEntity<List<DealerCenter>> getAllCenters() {

        try {

            List<DealerCenter> dealerCenters = new ArrayList<DealerCenter>(dealerCenterRepository.findAll());

            if (dealerCenters.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(dealerCenters, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

