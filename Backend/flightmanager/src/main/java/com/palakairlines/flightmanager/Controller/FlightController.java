package com.palakairlines.flightmanager.Controller;

import com.palakairlines.flightmanager.DTO.ApiResponse;
import com.palakairlines.flightmanager.DTO.FlightDTO;
import com.palakairlines.flightmanager.Model.Flight;
import com.palakairlines.flightmanager.Service.FlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/scheduleFlight/{scheduleFlightId}/Flight")
    public ResponseEntity<FlightDTO> addFlight(@Valid @RequestBody FlightDTO flightDTO, @PathVariable BigInteger scheduleFlightId)
    {
        FlightDTO addedFlightDTO = this.flightService.addFlight(flightDTO,scheduleFlightId);
        return new ResponseEntity<>(addedFlightDTO, HttpStatus.CREATED);
    }

    @PutMapping("/scheduleFlight/flight/{flightNumber}")
    public ResponseEntity<FlightDTO> updateFlight(@Valid @RequestBody FlightDTO flightDTO, @PathVariable BigInteger flightNumber)
    {
        FlightDTO updatedFlightDTO = this.flightService.updateFlight(flightDTO,flightNumber);
        return ResponseEntity.ok(updatedFlightDTO);
    }

    @DeleteMapping("/scheduleFlight/flight/{flightNumber}")
    public ResponseEntity<ApiResponse> deleteFlight(@PathVariable BigInteger flightNumber)
    {
        this.flightService.deleteFlight(flightNumber);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Flight Deleted Successfully",true),HttpStatus.OK);
    }

    @GetMapping("/scheduleFlight/flight/{flightNumber}")
    public ResponseEntity<FlightDTO> getFlight(@PathVariable BigInteger flightNumber)
    {
        FlightDTO flightDTO = this.flightService.getFlight(flightNumber);
        return ResponseEntity.ok(flightDTO);
    }

    @GetMapping("/scheduleFlight/flights")
    public ResponseEntity<List<FlightDTO>> getAllFlights()
    {
        List<FlightDTO> flightDTOS= this.flightService.getAllFlights();
        return ResponseEntity.ok(flightDTOS);
    }

    @GetMapping("/scheduleFlight/{scheduleFlightId}/flights")
    public ResponseEntity<FlightDTO> getFlightByScheduleFlight(@PathVariable BigInteger scheduleFlightId)
    {
        FlightDTO flightDTO = this.flightService.getFlightByScheduleFlight(scheduleFlightId);
        return ResponseEntity.ok(flightDTO);
    }
}
