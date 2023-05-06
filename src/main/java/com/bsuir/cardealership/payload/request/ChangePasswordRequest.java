package com.bsuir.cardealership.payload.request;

import javax.validation.constraints.NotBlank;

public class ChangePasswordRequest {
    @NotBlank
    private Long userId;

    @NotBlank
    private String newPassword;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
