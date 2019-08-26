package com.customer.travelBooking.customerjourney.resource;

import com.customer.travelBooking.customerjourney.dto.CustomerDTO;
import com.customer.travelBooking.customerjourney.dto.CustomerJourneyDTO;
import com.customer.travelBooking.customerjourney.dto.JourneyPricingDTO;
import com.customer.travelBooking.customerjourney.dto.JourneyRequestDTO;
import com.customer.travelBooking.customerjourney.service.CustomerJourneyService;
import com.customer.travelBooking.customerjourney.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/journey")
public class CustomerJourneyResourceImpl implements CustomerJourneyResource {

    @Autowired
    CustomerJourneyService customerJourneyService;


    @PostMapping(value = "/addJourney", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<CustomerJourneyDTO> addJourneyDetails(@RequestBody CustomerJourneyDTO customerJourneyDTO) {

        customerJourneyService.addJourneyDetails(customerJourneyDTO);
        return new ResponseEntity<CustomerJourneyDTO>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/getPricingDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<JourneyPricingDTO> getPricingDetails(@RequestBody JourneyRequestDTO journeyRequestDTO) {

        JourneyPricingDTO pricingDetails = customerJourneyService.getPricingDetails(journeyRequestDTO);
        return new ResponseEntity<JourneyPricingDTO>(pricingDetails, HttpStatus.OK);
    }
}
