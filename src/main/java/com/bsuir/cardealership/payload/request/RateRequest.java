package com.bsuir.cardealership.payload.request;

import javax.validation.constraints.NotBlank;

public class RateRequest {
    @NotBlank
    private Long orderId;

    @NotBlank
    private Double value;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
