package com.customer.travelBooking.controller;


import com.customer.travelBooking.customerjourney.dto.CustomerDTO;
import com.customer.travelBooking.customerjourney.dto.CustomerJourneyDTO;
import com.customer.travelBooking.customerjourney.dto.JourneyPricingDTO;
import com.customer.travelBooking.customerjourney.dto.JourneyRequestDTO;
import com.customer.travelBooking.customerjourney.repository.Customer;
import com.customer.travelBooking.customerjourney.repository.CustomerRepository;
import com.customer.travelBooking.customerjourney.resource.CustomerJourneyResourceImpl;
import com.customer.travelBooking.customerjourney.resource.CustomerResource;
import com.customer.travelBooking.customerjourney.resource.CustomerResourceImpl;
import com.customer.travelBooking.customerjourney.service.CustomerJourneyService;
import com.customer.travelBooking.customerjourney.service.CustomerJourneyServiceImpl;
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
import org.springframework.web.context.WebApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = CustomerResource.class, secure = false)
@ContextConfiguration(classes = {CustomerJourneyResourceImpl.class, WebApplicationContext.class})
@WebAppConfiguration
public class CustomerJourneyResourceTest {

    @Autowired
    private MockMvc mvc;


    @MockBean
    private CustomerJourneyService customerJourneyService;


    CustomerJourneyDTO mockJourneyData = new CustomerJourneyDTO(1,1,new Date(),"MUM-PUN");
    JourneyRequestDTO mockJourneyRequestDate = new JourneyRequestDTO(1,1,"25-08-2019","MUM-PUNE");

    ObjectMapper objectMapper = new ObjectMapper();
    String journeyJson = objectMapper.writeValueAsString(mockJourneyData);
    String pricingJson = objectMapper.writeValueAsString(mockJourneyRequestDate);

    public CustomerJourneyResourceTest() throws JsonProcessingException, ParseException {
    }

    @Test
    public void addJourneyDataTest() throws Exception {
        MvcResult result1 = mvc.perform(
                post("/api/journey/addJourney")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(journeyJson))
                .andExpect(status().isCreated())
                .andReturn();

        assertEquals(HttpStatus.CREATED.value(), result1.getResponse().getStatus());

    }

    @Test
    public void getPricingDetailsTest() throws Exception {

        JourneyPricingDTO journeyPricingDTO = new JourneyPricingDTO("£1.40","Ganesh","MUM-PUN");
        JourneyRequestDTO journeyRequestDTO = new JourneyRequestDTO(1,1,"25-08-2019","MUM-PUN");
        Mockito.when(customerJourneyService.getPricingDetails(journeyRequestDTO)).thenReturn(journeyPricingDTO);

        MvcResult result1 = mvc.perform(
                post("/api/journey/getPricingDetails")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(pricingJson))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(HttpStatus.OK.value(), result1.getResponse().getStatus());

    }
}

