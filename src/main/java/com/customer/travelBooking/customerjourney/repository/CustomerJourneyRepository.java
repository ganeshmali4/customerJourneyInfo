package com.customer.travelBooking.customerjourney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerJourneyRepository extends JpaRepository<CustomerJourney, Long> {

    @Query(value = "Select count(*) from Customer_Journey  where  journey_start_date > DATEADD('DAY',-2, NOW()) and route_name= :routeName" , nativeQuery = true)
    public int getCountByDate(@Param("routeName") String routeName);
}
