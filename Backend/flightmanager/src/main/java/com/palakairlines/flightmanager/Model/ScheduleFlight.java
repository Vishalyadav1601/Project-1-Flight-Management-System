package com.palakairlines.flightmanager.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ScheduleFlight implements Serializable {
    @Id
    @GeneratedValue(generator = "FourDigitIdGenerator")
    @GenericGenerator(name = "FourDigitIdGenerator", strategy = "com.palakairlines.flightmanager.CustomGenerator.FourDigitIdGenerator")
    private BigInteger scheduleFlightId;
    private String sourceAirport;
    private String destinationAirport;
    private ZonedDateTime departureDateTime;
    private ZonedDateTime arrivalDateTime;
    private String date;
    private int ticketCost;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;
    @OneToOne(mappedBy = "scheduleFlight")
    private Flight flight;
    @OneToMany(mappedBy = "scheduleFlight")
    private List<Passenger> passengers = new ArrayList<>();




}

