package com.customer.travelBooking.customerjourney.dto;

public enum CustomerType {
    VIP("VIP"),
    PERSONA_NON_GRATA("Persona Non Grata"),
    NORMAL("Normal");

    private final String type;

    CustomerType(String type) {
        this.type = type;
    }

    public String getCustomerType() {
        return this.type;
    }
}
