package com.bsuir.cardealership.payload.request;

import javax.validation.constraints.NotBlank;

public class ChangeUserInfoRequest {
    @NotBlank
    private Long userId;
    @NotBlank
    private String username;

    @NotBlank
    private String name;

    @NotBlank
    private String number;

    @NotBlank
    private String email;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
