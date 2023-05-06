package com.bsuir.cardealership.controller;

import com.bsuir.cardealership.model.Car;
import com.bsuir.cardealership.model.Order;
import com.bsuir.cardealership.model.OrderStatus;
import com.bsuir.cardealership.model.User;
import com.bsuir.cardealership.payload.request.ChangePasswordRequest;
import com.bsuir.cardealership.payload.request.ChangeUserInfoRequest;
import com.bsuir.cardealership.payload.request.StatusRequest;
import com.bsuir.cardealership.payload.response.UserInfoResponse;
import com.bsuir.cardealership.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {

        try {
            List<User> users = new ArrayList<User>(userRepository.findAll());

            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<User> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest, @PathVariable Long id) {
        User user = userRepository.findUserById(changePasswordRequest.getUserId());
        user.setPassword(encoder.encode(changePasswordRequest.getNewPassword()));
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> changeUserInfo(@RequestBody ChangeUserInfoRequest changeUserInfoRequest, @PathVariable Long id) {
        User user = userRepository.findUserById(changeUserInfoRequest.getUserId());
        user.setUsername(changeUserInfoRequest.getUsername());
        user.setEmail(changeUserInfoRequest.getEmail());
        user.setName(changeUserInfoRequest.getName());
        user.setNumber(changeUserInfoRequest.getNumber());
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
    }
}
