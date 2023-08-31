package com.palakairlines.flightmanager.Service;

import com.palakairlines.flightmanager.DTO.ScheduleFlightDTO;


import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface ScheduleFlightService {

    ScheduleFlightDTO scheduleFlight(ScheduleFlightDTO scheduleFlightDTO, BigInteger userId);
    ScheduleFlightDTO updateScheduledFlight(ScheduleFlightDTO scheduleFlightDTO,BigInteger scheduleFlightId);
    ScheduleFlightDTO viewScheduledFlight(BigInteger scheduleFlightId);
    List<ScheduleFlightDTO> viewAllScheduledFlights();
    List<ScheduleFlightDTO> viewScheduledFlightByUser(BigInteger userId);
    void deleteScheduledFlight(BigInteger scheduleFlightId);
    List<ScheduleFlightDTO> searchScheduleFlights(String sourceAirport, String destinationAirport,String date);

}
