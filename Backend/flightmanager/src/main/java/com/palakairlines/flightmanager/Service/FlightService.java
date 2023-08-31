package com.palakairlines.flightmanager.Service;

import com.palakairlines.flightmanager.DTO.FlightDTO;


import java.math.BigInteger;
import java.util.List;

public interface FlightService {

    FlightDTO addFlight (FlightDTO flightDTO,BigInteger scheduleFlightId);
    FlightDTO updateFlight(FlightDTO flightDTO,BigInteger flightNumber);
    void deleteFlight(BigInteger flightNumber);
    FlightDTO getFlight(BigInteger flightNumber);
    List<FlightDTO> getAllFlights();
    FlightDTO getFlightByScheduleFlight(BigInteger scheduleFlightId);

}
