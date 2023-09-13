package com.rhitmo.rhitmohospedeapi.core.domain.enumeration;


public enum BookingStatus {

    CONFIRMED((short) 1), CANCELLED((short) 0);

    private Short valorBookingStatus;

    BookingStatus(Short valor) {
        valorBookingStatus = valor;
    }

    public Short getValorBookingStatus() {
        return valorBookingStatus;
    }


}
