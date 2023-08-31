package com.palakairlines.flightmanager.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@Component
public class FlightDTO {
    private BigInteger flightNumber;
    @NotEmpty(message = "Flight Model is invalid")
    private String flightModel;
    @NotEmpty(message = "Carrier Name is invalid")
    private String carrierName;
    @NotEmpty(message = "Seat Capacity")
    private int seatCapacity;
    private ScheduleFlightDTO scheduleFlight;
}
