package com.bsuir.cardealership.payload.request;

import javax.validation.constraints.NotBlank;

public class StatusRequest {
    @NotBlank
    private Long orderId;

    @NotBlank
    private Long statusId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }
}
