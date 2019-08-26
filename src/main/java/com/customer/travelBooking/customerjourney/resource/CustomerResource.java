package com.customer.travelBooking.customerjourney.resource;

import com.customer.travelBooking.customerjourney.dto.CustomerDTO;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;

public interface CustomerResource {

    public ResponseEntity <Void> addCustomer(CustomerDTO customerDTO) throws ParseException;
}
