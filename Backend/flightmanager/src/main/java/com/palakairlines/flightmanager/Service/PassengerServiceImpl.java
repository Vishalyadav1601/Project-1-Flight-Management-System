package com.palakairlines.flightmanager.Service;

import com.palakairlines.flightmanager.DTO.PassengerDTO;
import com.palakairlines.flightmanager.Exceptions.ResourceNotFoundException;
import com.palakairlines.flightmanager.Model.Passenger;
import com.palakairlines.flightmanager.Model.ScheduleFlight;
import com.palakairlines.flightmanager.dao.PassengerDao;
import com.palakairlines.flightmanager.dao.ScheduleFlightDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImpl implements PassengerService{

    @Autowired
    private PassengerDao passengerDao;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ScheduleFlightDao scheduleFlightDao;
    @Override
    public PassengerDTO addPassenger(PassengerDTO passengerDTO, BigInteger scheduleFlightId) {
        ScheduleFlight scheduleFlight = this.scheduleFlightDao.findById(scheduleFlightId).orElseThrow(()->new ResourceNotFoundException("Schedule Flight","Id",scheduleFlightId));
        Passenger passenger = this.DTOtoPassenger(passengerDTO);
        passenger.setScheduleFlight(scheduleFlight);
        Passenger addedPassenger = this.passengerDao.save(passenger);
        return PassengerToDTO(addedPassenger);
    }

    @Override
    public PassengerDTO updatePassenger(PassengerDTO passengerDTO, BigInteger passengerUIN) {
        Passenger passenger = this.passengerDao.findById(passengerUIN).orElseThrow(()->new ResourceNotFoundException("Passenger","UIN",passengerUIN));
        passenger.setPnrNumber(passengerDTO.getPnrNumber());
        passenger.setPassengerName(passengerDTO.getPassengerName());
        passenger.setPassengerAge(passengerDTO.getPassengerAge());
        passenger.setLuggage(passengerDTO.getLuggage());
        Passenger updatedPassenger = this.passengerDao.save(passenger);
        PassengerDTO updatedPassengerDTO = this.PassengerToDTO(updatedPassenger);
        return updatedPassengerDTO;
    }

    @Override
    public void deletePassenger(BigInteger passengerUIN) {
        Passenger passenger = this.passengerDao.findById(passengerUIN).orElseThrow(()->new ResourceNotFoundException("Passenger","Name",passengerUIN));
        this.passengerDao.delete(passenger);
    }

    @Override
    public PassengerDTO viewPassenger(BigInteger passengerUIN) {
        Passenger passenger = this.passengerDao.findById(passengerUIN).orElseThrow(()->new ResourceNotFoundException("Passenger","Name",passengerUIN));
        return PassengerToDTO(passenger);
    }

    @Override
    public List<PassengerDTO> viewAllPassengers() {
        List<Passenger> passengers = this.passengerDao.findAll();
        List<PassengerDTO> passengerDTOS = passengers.stream().map(Passenger->PassengerToDTO(Passenger)).collect(Collectors.toList());
        return passengerDTOS;
    }

    @Override
    public List<PassengerDTO> viewPassengerByScheduleFlight(BigInteger scheduleFlightId) {
        ScheduleFlight scheduleFlight = this.scheduleFlightDao.findById(scheduleFlightId).orElseThrow(()->new ResourceNotFoundException("Schedule","Flight",scheduleFlightId));
        List<Passenger> passenger = this.passengerDao.findByScheduleFlight(scheduleFlight);
        List<PassengerDTO> passengerDTOS = passenger.stream().map(Passenger->PassengerToDTO(Passenger)).collect(Collectors.toList());
        return passengerDTOS;
    }

    private Passenger DTOtoPassenger(PassengerDTO passengerDTO)
    {
        Passenger passenger = this.modelMapper.map(passengerDTO,Passenger.class);
        return passenger;
    }

    private PassengerDTO PassengerToDTO(Passenger passenger)
    {
        PassengerDTO passengerDTO = this.modelMapper.map(passenger,PassengerDTO.class);
        return passengerDTO;
    }
}
