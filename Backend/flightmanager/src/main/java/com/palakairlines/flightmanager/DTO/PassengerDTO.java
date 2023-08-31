package com.palakairlines.flightmanager.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@Component
public class PassengerDTO {
    private BigInteger passengerUIN;

    @NotNull(message = "pnr Number is invalid")
    private BigInteger pnrNumber;
    @NotEmpty(message = "Passenger Name not Valid")
    private String passengerName;
    @NotNull(message = "Passenger Age not Valid")
    @Positive(message = "Passenger age can not be zero")
    private int passengerAge;
    @NotNull(message = "Passenger Luggage not Valid")
    private Double luggage;

    private ScheduleFlightDTO scheduleFlight;

}
//    public PassengerDTO() {
//    }
//
//    public PassengerDTO(BigInteger pnrNumber, String passengerName, int passengerAge, BigInteger passengerUIN, Double luggage) {
//        this.pnrNumber = pnrNumber;
//        this.passengerName = passengerName;
//        this.passengerAge = passengerAge;
//        this.passengerUIN = passengerUIN;
//        this.luggage = luggage;
//    }
//
//    public BigInteger getPnrNumber() {
//        return pnrNumber;
//    }
//
//    public void setPnrNumber(BigInteger pnrNumber) {
//        this.pnrNumber = pnrNumber;
//    }
//
//    public String getPassengerName() {
//        return passengerName;
//    }
//
//    public void setPassengerName(String passengerName) {
//        this.passengerName = passengerName;
//    }
//
//    public int getPassengerAge() {
//        return passengerAge;
//    }
//
//    public void setPassengerAge(int passengerAge) {
//        this.passengerAge = passengerAge;
//    }
//
//    public BigInteger getPassengerUIN() {
//        return passengerUIN;
//    }
//
//    public void setPassengerUIN(BigInteger passengerUIN) {
//        this.passengerUIN = passengerUIN;
//    }
//
//    public Double getLuggage() {
//        return luggage;
//    }
//
//    public void setLuggage(Double luggage) {
//        this.luggage = luggage;
//    }
//}

