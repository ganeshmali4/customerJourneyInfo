package com.customer.travelBooking.customerjourney.dto;

public class JourneyPricingDTO {

    String price;
    String customerName;
    String routeName;

    public JourneyPricingDTO() {
    }

    @Override
    public String toString() {
        return "JourneyPricingDTO{" +
                "price='" + price + '\'' +
                ", customerName='" + customerName + '\'' +
                ", routeName='" + routeName + '\'' +
                '}';
    }

    public JourneyPricingDTO(String price, String customerName, String routeName) {
        this.price = price;
        this.customerName = customerName;
        this.routeName = routeName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }
}
