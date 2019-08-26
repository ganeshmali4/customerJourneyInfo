package com.customer.travelBooking.customerjourney.service;

import com.customer.travelBooking.customerjourney.dto.CustomerDTO;

import java.text.ParseException;

public interface CustomerProfileService {

    public void addCustomer(CustomerDTO customerDTO) throws ParseException;
}
