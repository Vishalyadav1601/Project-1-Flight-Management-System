package com.palakairlines.flightmanager.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.ZonedDateTime;


@Getter
@Setter
@NoArgsConstructor
@Component
public class ScheduleFlightDTO {
    private BigInteger scheduleFlightId;
    @NotEmpty(message = "Source Airport is Not Valid")
    private String sourceAirport;
    @NotEmpty(message = "Destination Airport is Not Valid")
    private String destinationAirport;
    @NotNull(message = "Departure Date and Time is not Valid")
    private ZonedDateTime departureDateTime;
    @NotNull(message = "Arrival Date and Time is not Valid")
    private ZonedDateTime arrivalDateTime;
    @NotNull(message = "Date is not Valid")
    private String date;
    @NotNull(message = "Ticket Cost is not Valid")
    private int ticketCost;
    private UserDTO user;

}
