package com.customer.travelBooking.customerjourney.service;

import com.customer.travelBooking.customerjourney.dto.CustomerDTO;
import com.customer.travelBooking.customerjourney.repository.Customer;
import com.customer.travelBooking.customerjourney.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addCustomer(CustomerDTO customerDTO) throws ParseException {
        Customer customer= convertToEntity(customerDTO);
        customerRepository.save(customer);
    }


    private Customer convertToEntity(CustomerDTO customerDTO) throws ParseException{
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setCustomerType(customerDTO.getCustomerType());
        customer.setFavouriteRoute(customerDTO.getFavouriteRoute());
        return customer;
    }
}
