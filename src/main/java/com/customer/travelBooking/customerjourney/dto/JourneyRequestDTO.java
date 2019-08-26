package com.customer.travelBooking.customerjourney.dto;

public class JourneyRequestDTO {

    private long journeyId;

    private long customerId;

    private String bookingDate;

    private String routeName;

    public JourneyRequestDTO() {
    }

    public JourneyRequestDTO(long journeyId, long customerId, String bookingDate, String routeName) {
        this.journeyId = journeyId;
        this.customerId = customerId;
        this.bookingDate = bookingDate;
        this.routeName = routeName;
    }

    public long getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(long journeyId) {
        this.journeyId = journeyId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }
}
