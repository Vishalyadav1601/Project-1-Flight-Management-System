package com.palakairlines.flightmanager.dao;

import com.palakairlines.flightmanager.Model.Flight;
import com.palakairlines.flightmanager.Model.Passenger;
import com.palakairlines.flightmanager.Model.ScheduleFlight;
import com.palakairlines.flightmanager.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface ScheduleFlightDao extends JpaRepository<ScheduleFlight, BigInteger> {
    List<ScheduleFlight> findByUser(Users user);
    @Query("SELECT sf FROM ScheduleFlight sf " +
            "WHERE sf.sourceAirport LIKE %:sourceAirport% " +
            "AND sf.destinationAirport LIKE %:destinationAirport% " +
            "AND sf.date LIKE %:date%")
    List<ScheduleFlight> findBySourceAirportAndDestinationAirportAndDate
            (@RequestParam("sourceAirport") String sourceAirport,
             @RequestParam("destinationAirport") String destinationAirport,
             @RequestParam("date") String date);
}
