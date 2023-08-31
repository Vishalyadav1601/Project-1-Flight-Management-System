package com.palakairlines.flightmanager.Controller;

import com.palakairlines.flightmanager.DTO.*;
import com.palakairlines.flightmanager.Service.FlightService;
import com.palakairlines.flightmanager.Service.PassengerService;
import com.palakairlines.flightmanager.Service.ScheduleFlightService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ScheduleFlightController {
    @Autowired
    private ScheduleFlightService scheduleFlightService;
    @Autowired
    private PassengerService passengerService;
    @Autowired
    private FlightService flightService;

    @PostMapping("/user/{userId}")
    public ResponseEntity<ScheduleFlightDTO> scheduleFlight(@Valid @RequestBody ScheduleFlightDTO scheduleFlightDTO, @PathVariable BigInteger userId) {
        ScheduleFlightDTO scheduledFlightDTO = this.scheduleFlightService.scheduleFlight(scheduleFlightDTO, userId);
        return new ResponseEntity<>(scheduledFlightDTO, HttpStatus.CREATED);
    }

    @PutMapping("user/ScheduledFlight/{scheduleFlightId}")
    public ResponseEntity<ScheduleFlightDTO> updateScheduledFlight(@Valid @RequestBody ScheduleFlightDTO scheduleFlightDTO, @PathVariable BigInteger scheduleFlightId) {
        ScheduleFlightDTO updatedScheduledFlight = this.scheduleFlightService.updateScheduledFlight(scheduleFlightDTO, scheduleFlightId);
        return ResponseEntity.ok(updatedScheduledFlight);
    }

    @DeleteMapping("user/ScheduledFlight/{scheduleFlightId}")
    public ResponseEntity<ApiResponse> deleteScheduledFlight(@PathVariable BigInteger scheduleFlightId) {
        this.scheduleFlightService.deleteScheduledFlight(scheduleFlightId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Scheduled Flight Deleted Succussfully", true), HttpStatus.OK);
    }

    @GetMapping("user/ScheduleFlight/{scheduleFlightId}")
    public ResponseEntity<ScheduleFlightDTO> viewScheduledFlight(@PathVariable BigInteger scheduleFlightId) {
        ScheduleFlightDTO scheduleFlightDTO = this.scheduleFlightService.viewScheduledFlight(scheduleFlightId);
        return ResponseEntity.ok(scheduleFlightDTO);
    }

    @GetMapping("user/ScheduleFlights")
    public ResponseEntity<List<ScheduleFlightDTO>> viewAllScheduledFlights() {
        List<ScheduleFlightDTO> scheduleFlightDTOS = this.scheduleFlightService.viewAllScheduledFlights();
        return ResponseEntity.ok(scheduleFlightDTOS);
    }

    @GetMapping("user/{userId}/ScheduleFlights")
    public ResponseEntity<List<ScheduleFlightDTO>> viewScheduledFlightByUser(@PathVariable BigInteger userId) {
        List<ScheduleFlightDTO> scheduledFlights = this.scheduleFlightService.viewScheduledFlightByUser(userId);
        return ResponseEntity.ok(scheduledFlights);
    }

    @GetMapping("/user/ScheduleFlights/search/{sourceAirport}/{destinationAirport}/{date}")
    public ResponseEntity<List<ScheduleFlightDTO>> searchScheduleFlights(@PathVariable String sourceAirport,@PathVariable String destinationAirport,@PathVariable String date)
    {
        List<ScheduleFlightDTO> scheduleFlightDTOS = this.scheduleFlightService.searchScheduleFlights(sourceAirport,destinationAirport,date);
        return ResponseEntity.ok(scheduleFlightDTOS);
    }

    @GetMapping("user/ScheduleFlight/{scheduleFlightId}/ticket")
    public ResponseEntity<CombinedResponseDTO> viewTicket(@PathVariable BigInteger scheduleFlightId)
    {
        CombinedResponseDTO combinedResponseDTO = new CombinedResponseDTO();
        List<PassengerDTO> passengerDTOS = this.passengerService.viewPassengerByScheduleFlight(scheduleFlightId);
        FlightDTO flightDTO = this.flightService.getFlightByScheduleFlight(scheduleFlightId);
        combinedResponseDTO.setPassengers(passengerDTOS);
        combinedResponseDTO.setFlight(flightDTO);
        return ResponseEntity.ok(combinedResponseDTO);
    }
}
