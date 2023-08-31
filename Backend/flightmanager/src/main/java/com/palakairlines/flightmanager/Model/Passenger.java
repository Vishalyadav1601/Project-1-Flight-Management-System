package com.palakairlines.flightmanager.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Passenger implements Serializable {

    @Id
    @GeneratedValue(generator = "TwelveDigitUINGenerator")
    @GenericGenerator(name = "TwelveDigitUINGenerator", strategy = "com.palakairlines.flightmanager.CustomGenerator.TwelveDigitUINGenerator")
    @Column(length = 12)
    private BigInteger passengerUIN;
    private BigInteger pnrNumber;

    private String passengerName;
    private int passengerAge;
    private Double luggage;

    @ManyToOne
    @JoinColumn(name = "scheduleFlightId")
    private ScheduleFlight scheduleFlight;


//    public Passenger() {
//    }
//
//    public Passenger(BigInteger passengerUIN, BigInteger pnrNumber, String passengerName, int passengerAge, Double luggage) {
//        this.passengerUIN = passengerUIN;
//        this.pnrNumber = pnrNumber;
//        this.passengerName = passengerName;
//        this.passengerAge = passengerAge;
//        this.luggage = luggage;
//
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
//    public Double getLuggage() {
//        return luggage;
//    }
//
//    public void setLuggage(Double luggage) {
//        this.luggage = luggage;
//    }


}
