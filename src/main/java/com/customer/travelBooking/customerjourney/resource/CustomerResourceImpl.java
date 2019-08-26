package com.customer.travelBooking.customerjourney.resource;

import com.customer.travelBooking.customerjourney.dto.CustomerDTO;
import com.customer.travelBooking.customerjourney.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerResourceImpl implements CustomerResource {

    @Autowired
    CustomerProfileService customerProfileService;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity <Void> addCustomer(@RequestBody CustomerDTO customerDTO) throws ParseException {
        System.out.println("Creating customer account");
        customerProfileService.addCustomer(customerDTO);
        return new ResponseEntity<Void>(HttpStatus.CREATED);

    }
}
