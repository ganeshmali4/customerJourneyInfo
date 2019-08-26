package com.customer.travelBooking.customerjourney.repository;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Customer_Journey")
public class CustomerJourney {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="journey_id")
    private long journeyId;

    @Column(name="customer_id")
    private long customerId;

    @Column(name="journey_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name="route_name")
    private String routeName;

    @Override
    public String toString() {
        return "CustomerJourney{" +
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
