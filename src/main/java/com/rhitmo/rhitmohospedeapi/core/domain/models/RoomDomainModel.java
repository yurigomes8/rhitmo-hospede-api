package com.rhitmo.rhitmohospedeapi.core.domain.models;

import com.rhitmo.rhitmohospedeapi.core.domain.enumeration.RoomStatus;

public class RoomDomainModel {

    private Double dailyAmount;

    private String description;

    private RoomStatus status;

    public RoomDomainModel(Double dailyAmount, String description, RoomStatus status) {
        this.dailyAmount = dailyAmount;
        this.description = description;
        this.status = status;
    }

    public Double getDailyAmount() {
        return dailyAmount;
    }

    public void setDailyAmount(Double dailyAmount) {
        this.dailyAmount = dailyAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }
}
