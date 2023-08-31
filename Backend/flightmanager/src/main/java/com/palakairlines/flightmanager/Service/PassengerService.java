package com.palakairlines.flightmanager.Service;

import com.palakairlines.flightmanager.DTO.PassengerDTO;
import com.palakairlines.flightmanager.DTO.ScheduleFlightDTO;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface PassengerService {

    PassengerDTO addPassenger(PassengerDTO passengerDTO, BigInteger scheduleFlightId);
    PassengerDTO updatePassenger(PassengerDTO passengerDTO,BigInteger passengerUIN);
    void deletePassenger(BigInteger passengerUIN);
    PassengerDTO viewPassenger(BigInteger passengerUIN);
    List<PassengerDTO> viewAllPassengers();
    List<PassengerDTO> viewPassengerByScheduleFlight(BigInteger scheduleFlightId);


}
