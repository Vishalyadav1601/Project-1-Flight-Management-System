package com.palakairlines.flightmanager.dao;

import com.palakairlines.flightmanager.Model.Passenger;
import com.palakairlines.flightmanager.Model.ScheduleFlight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface PassengerDao extends JpaRepository<Passenger, BigInteger> {

    List<Passenger> findByScheduleFlight(ScheduleFlight scheduleFlight);
}
