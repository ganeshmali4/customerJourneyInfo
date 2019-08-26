package com.customer.travelBooking.controller;


import com.customer.travelBooking.customerjourney.dto.CustomerDTO;
import com.customer.travelBooking.customerjourney.dto.CustomerJourneyDTO;
import com.customer.travelBooking.customerjourney.repository.Customer;
import com.customer.travelBooking.customerjourney.repository.CustomerRepository;
import com.customer.travelBooking.customerjourney.resource.CustomerJourneyResourceImpl;
import com.customer.travelBooking.customerjourney.resource.CustomerResource;
import com.customer.travelBooking.customerjourney.resource.CustomerResourceImpl;
import com.customer.travelBooking.customerjourney.service.CustomerProfileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = CustomerResource.class, secure = false)
@ContextConfiguration(classes = {CustomerResourceImpl.class})
@WebAppConfiguration
public class CustomerResourceTest {

    @Autowired
    private MockMvc mvc;


    @MockBean
    private CustomerProfileService customerProfileService;


    CustomerDTO mockCustomer = new CustomerDTO(1,"Normal", "Ganesh", "MUM-PUN");

    ObjectMapper objectMapper = new ObjectMapper();
    String customerJson = objectMapper.writeValueAsString(mockCustomer);

    public CustomerResourceTest() throws JsonProcessingException, ParseException {
    }

    @Test
    public void addCustomerProfile() throws Exception {
        MvcResult result1 = mvc.perform(
                post("/api/customer/create")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(customerJson))
                .andExpect(status().isCreated())
                .andReturn();


        assertEquals(HttpStatus.CREATED.value(), result1.getResponse().getStatus());

    }
}
