package com.customer.travelBooking.customerjourney.service;

import com.customer.travelBooking.customerjourney.dto.*;
import com.customer.travelBooking.customerjourney.repository.Customer;
import com.customer.travelBooking.customerjourney.repository.CustomerJourney;
import com.customer.travelBooking.customerjourney.repository.CustomerJourneyRepository;
import com.customer.travelBooking.customerjourney.repository.CustomerRepository;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class CustomerJourneyServiceImpl implements CustomerJourneyService {

    @Autowired
    CustomerJourneyRepository customerJourneyRepository;

    @Value("${customer.standard.favourite.discount}")
    private Double stdDiscount;

    @Value("${customer.standard.journey.price}")
    private Integer stdJourneyPrice;

    @Value("${customer.vip.journey.price}")
    private Integer vipJourneyPrice;

    @Value("${customer.special.discount.price}")
    private Double spclDiscount;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void addJourneyDetails(CustomerJourneyDTO customerJourneyDto) {
        System.out.println("all Prices "+stdDiscount+" "+stdJourneyPrice+" "+vipJourneyPrice+" "+spclDiscount);
        CustomerJourney customerJourney = convertToEntity(customerJourneyDto);
        customerJourneyRepository.save(customerJourney);
    }

    @Override
    public JourneyPricingDTO getPricingDetails(JourneyRequestDTO journeyRequestDTO) {
        JourneyPricingDTO journeyPricingDTO = new JourneyPricingDTO();
        Double totalPrice = 0.0;
        Optional<Customer> customer = customerRepository.findById(journeyRequestDTO.getCustomerId());
        int nrOfBooking = customerJourneyRepository.getCountByDate(journeyRequestDTO.getRouteName());
        Customer currentCustomer;
        if(customer.isPresent()){
            currentCustomer = customer.get();
            journeyPricingDTO.setCustomerName(currentCustomer.getCustomerName());
            journeyPricingDTO.setRouteName(journeyRequestDTO.getRouteName());
            if(currentCustomer.getCustomerType().equals(CustomerType.VIP.getCustomerType())){
                totalPrice = Double.valueOf(vipJourneyPrice);
            }
            else{
                totalPrice = Double.valueOf(stdJourneyPrice);
            }
            if(currentCustomer.getFavouriteRoute().equalsIgnoreCase(journeyRequestDTO.getRouteName())
                    && !(currentCustomer.getCustomerType().equals(CustomerType.PERSONA_NON_GRATA.getCustomerType()))){
                totalPrice = totalPrice - (totalPrice * stdDiscount);
            }

            if(nrOfBooking > 2 && !currentCustomer.getCustomerType().equals(CustomerType.PERSONA_NON_GRATA.getCustomerType()) ){
                totalPrice = totalPrice - (totalPrice * spclDiscount);
            }
            journeyPricingDTO.setPrice(NumberFormat.getCurrencyInstance(Locale.UK).format(totalPrice));
        }
        return journeyPricingDTO;
    }

    private CustomerJourney convertToEntity(CustomerJourneyDTO customerJourneyDTO) {
        CustomerJourney customerJourney = modelMapper.map(customerJourneyDTO, CustomerJourney.class);
        customerJourney.setCustomerId(customerJourneyDTO.getCustomerId());
        customerJourney.setRouteName(customerJourneyDTO.getRouteName());
        customerJourney.setStartDate(customerJourneyDTO.getStartDate());
        return customerJourney;
    }
}
