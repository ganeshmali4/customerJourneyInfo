package com.customer.travelBooking.customerjourney.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class CustomerDTO {

    private long customerId;

    private String customerType;

    private String customerName;

    private String favouriteRoute;

    public CustomerDTO() {
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId=" + customerId +
                ", customerType='" + customerType + '\'' +
                ", customerName='" + customerName + '\'' +
                ", favouriteRoute='" + favouriteRoute + '\'' +
                '}';
    }

    public CustomerDTO(long customerId, String customerType, String customerName, String favouriteRoute) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.customerName = customerName;
        this.favouriteRoute = favouriteRoute;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getFavouriteRoute() {
        return favouriteRoute;
    }

    public void setFavouriteRoute(String favouriteRoute) {
        this.favouriteRoute = favouriteRoute;
    }
}
