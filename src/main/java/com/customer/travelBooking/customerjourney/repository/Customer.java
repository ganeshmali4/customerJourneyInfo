package com.customer.travelBooking.customerjourney.repository;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="customer_id")
    private long customerId;

    @Column(name="customer_type")
    private String customerType;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="favourite_route")
    private String favouriteRoute;

    public Customer(String customerType, String customerName, String favouriteRoute) {
        this.customerType = customerType;
        this.customerName = customerName;
        this.favouriteRoute = favouriteRoute;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerType='" + customerType + '\'' +
                ", customerName='" + customerName + '\'' +
                ", favouriteRute='" + favouriteRoute + '\'' +
                '}';
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
