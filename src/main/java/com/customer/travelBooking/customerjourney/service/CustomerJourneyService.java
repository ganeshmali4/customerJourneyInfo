package com.customer.travelBooking.customerjourney.service;

import com.customer.travelBooking.customerjourney.dto.CustomerJourneyDTO;
import com.customer.travelBooking.customerjourney.dto.JourneyPricingDTO;
import com.customer.travelBooking.customerjourney.dto.JourneyRequestDTO;

public interface CustomerJourneyService {

    public  void addJourneyDetails(CustomerJourneyDTO customerJourneyDto);

    public JourneyPricingDTO getPricingDetails(JourneyRequestDTO journeyRequestDTO);
}
