package com.customer.travelBooking.customerjourney.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.joda.time.DateTime;

import javax.persistence.Column;
import java.util.Date;

@JsonIgnoreProperties
public class CustomerJourneyDTO {

    private long journeyId;

    private long customerId;

    private Date startDate;

    private String routeName;

    public CustomerJourneyDTO() {
    }

    public CustomerJourneyDTO(long journeyId, long customerId, Date startDate, String routeName) {
        this.journeyId = journeyId;
        this.customerId = customerId;
        this.startDate = startDate;
        this.routeName = routeName;
    }

    @Override
    public String toString() {
        return "CustomerJourneyDTO{" +
                "journeyId=" + journeyId +
                ", customerId=" + customerId +
                ", startDate='" + startDate + '\'' +
                ", routeName='" + routeName + '\'' +
                '}';
    }

    public long getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(long journeyId) {
        this.journeyId = journeyId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }
}
