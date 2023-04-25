package com.bsuir.cardealership.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class OrderRequest {
    @NotBlank
    private Long carId;
    @NotBlank
    private Long userId;

    @NotBlank
    private String time;

    @NotBlank
    private Long dealerCenterId;

    private Long statusId;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getDealerCenterId() {
        return dealerCenterId;
    }

    public void setDealerCenterId(Long dealerCenterId) {
        this.dealerCenterId = dealerCenterId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }
}
