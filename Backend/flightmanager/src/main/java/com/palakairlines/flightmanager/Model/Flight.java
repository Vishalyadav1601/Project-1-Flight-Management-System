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
public class Flight implements Serializable {
    @Id
    @GeneratedValue(generator = "ThreeDigitIdGenerator")
    @GenericGenerator(name = "ThreeDigitIdGenerator",strategy = "com.palakairlines.flightmanager.CustomGenerator.ThreeDigitIdGenerator")
    private BigInteger flightNumber;
    private String flightModel;
    private String carrierName;
    private int seatCapacity;

    @OneToOne
    @JoinColumn(name = "scheduleFlightId")
    private ScheduleFlight scheduleFlight;
}
