package com.customer.travelBooking.customerjourney.resource;

import com.customer.travelBooking.customerjourney.dto.CustomerDTO;
import com.customer.travelBooking.customerjourney.dto.CustomerJourneyDTO;
import com.customer.travelBooking.customerjourney.dto.JourneyPricingDTO;
import com.customer.travelBooking.customerjourney.dto.JourneyRequestDTO;
import org.springframework.http.ResponseEntity;

public interface CustomerJourneyResource {

    public ResponseEntity <CustomerJourneyDTO> addJourneyDetails(CustomerJourneyDTO customerJourneyDTO);

    public ResponseEntity<JourneyPricingDTO> getPricingDetails(JourneyRequestDTO journeyRequestDTO);
}
