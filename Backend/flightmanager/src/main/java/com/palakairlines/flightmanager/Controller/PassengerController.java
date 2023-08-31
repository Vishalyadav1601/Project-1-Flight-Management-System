package com.palakairlines.flightmanager.Controller;

import com.palakairlines.flightmanager.DTO.ApiResponse;
import com.palakairlines.flightmanager.DTO.PassengerDTO;
import com.palakairlines.flightmanager.Service.PassengerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping("/scheduleFlight/{scheduleFlightId}/passenger")
    public ResponseEntity<PassengerDTO> addPassenger(@Valid @RequestBody PassengerDTO passengerDTO, @PathVariable BigInteger scheduleFlightId)
    {
        PassengerDTO addedpassengerDTO = this.passengerService.addPassenger(passengerDTO,scheduleFlightId);
        return new ResponseEntity<>(addedpassengerDTO, HttpStatus.CREATED);
    }

    @PutMapping("/scheduleFlight/Passenger/{passengerUIN}")
    public ResponseEntity<PassengerDTO> updatePassenger(@Valid @RequestBody PassengerDTO passengerDTO,@PathVariable BigInteger passengerUIN)
    {
        PassengerDTO updatedPassengerDTO = this.passengerService.updatePassenger(passengerDTO,passengerUIN);
        return ResponseEntity.ok(updatedPassengerDTO);
    }

    @DeleteMapping("/scheduleFlight/Passenger/{passengerUIN}")
    public ResponseEntity<ApiResponse> deletePassenger(@PathVariable BigInteger passengerUIN)
    {
        this.passengerService.deletePassenger(passengerUIN);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Passenger Deleted Successfully",true),HttpStatus.OK);
    }

    @GetMapping("/scheduleFlight/Passenger/{passengerUIN}")
    public ResponseEntity<PassengerDTO> viewPassenger(@PathVariable BigInteger passengerUIN)
    {
        return ResponseEntity.ok(this.passengerService.viewPassenger(passengerUIN));
    }

    @GetMapping("/scheduleFlight/Passengers")
    public ResponseEntity<List<PassengerDTO>> viewAllPassenger()
    {
        List<PassengerDTO> passengerDTOS = this.passengerService.viewAllPassengers();
        return ResponseEntity.ok(passengerDTOS);
    }

    @GetMapping("/scheduleFlight/{scheduleFlightId}/passengers")
    public ResponseEntity<List<PassengerDTO>> viewPassengerByScheduleFlight(@PathVariable BigInteger scheduleFlightId)
    {
        List<PassengerDTO> passengerDTOS = this.passengerService.viewPassengerByScheduleFlight(scheduleFlightId);
        return ResponseEntity.ok(passengerDTOS);
    }
}
