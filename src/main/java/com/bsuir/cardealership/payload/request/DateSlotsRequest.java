package com.bsuir.cardealership.payload.request;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class DateSlotsRequest {
    @NotBlank
    private String date;

    public LocalDateTime getDate() {
        return LocalDateTime.parse(date);
    }

    public void setDate(String date) {
        this.date = date;
    }
}
