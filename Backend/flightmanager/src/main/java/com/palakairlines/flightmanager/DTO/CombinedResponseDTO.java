package com.palakairlines.flightmanager.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CombinedResponseDTO {
    private List<PassengerDTO> passengers;
    private FlightDTO flight;
}
