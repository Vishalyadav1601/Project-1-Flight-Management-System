package com.palakairlines.flightmanager.dao;

import com.palakairlines.flightmanager.Model.Flight;
import com.palakairlines.flightmanager.Model.ScheduleFlight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;


public interface FlightDao extends JpaRepository<Flight, BigInteger> {
    Flight findByScheduleFlight(ScheduleFlight scheduleFlight);
}
