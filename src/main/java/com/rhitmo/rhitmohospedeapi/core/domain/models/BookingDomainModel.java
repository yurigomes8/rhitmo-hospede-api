package com.rhitmo.rhitmohospedeapi.core.domain.models;

import com.rhitmo.rhitmohospedeapi.core.domain.enumeration.BookingStatus;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class BookingDomainModel {
    private OffsetDateTime checkIn;
    private OffsetDateTime checkOut;
    private BigDecimal totalAmount;
    private Integer roomId;
    private Integer userId;
    private BookingStatus status;


    public BookingDomainModel(OffsetDateTime checkIn, OffsetDateTime checkOut, BigDecimal totalAmount, Integer roomId, Integer userId, BookingStatus status) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalAmount = totalAmount;
        this.roomId = roomId;
        this.userId = userId;
        this.status = status;
    }

    public BookingDomainModel() {

    }

    public OffsetDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(OffsetDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public OffsetDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(OffsetDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
