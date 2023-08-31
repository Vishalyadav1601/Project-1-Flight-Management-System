package com.palakairlines.flightmanager.Service;


import com.palakairlines.flightmanager.DTO.PassengerDTO;
import com.palakairlines.flightmanager.DTO.ScheduleFlightDTO;
import com.palakairlines.flightmanager.Exceptions.ResourceNotFoundException;
import com.palakairlines.flightmanager.Model.Flight;
import com.palakairlines.flightmanager.Model.Passenger;
import com.palakairlines.flightmanager.Model.ScheduleFlight;

import com.palakairlines.flightmanager.Model.Users;
import com.palakairlines.flightmanager.dao.FlightDao;
import com.palakairlines.flightmanager.dao.PassengerDao;
import com.palakairlines.flightmanager.dao.ScheduleFlightDao;
import com.palakairlines.flightmanager.dao.UserDao;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleFlightServiceImpl implements ScheduleFlightService{
    @Autowired
    private ScheduleFlightDao scheduleFlightDao;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserDao userDao;
    @Autowired
    private PassengerDao passengerDao;
    @Autowired
    private FlightDao flightDao;

    @Override
    public ScheduleFlightDTO scheduleFlight(ScheduleFlightDTO scheduleFlightDTO, BigInteger userId) {
        Users user = this.userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
        ScheduleFlight scheduleFlight = this.DTOtoScheduleFlight(scheduleFlightDTO);
        scheduleFlight.setUser(user);
        ScheduleFlight scheduledFlight = this.scheduleFlightDao.save(scheduleFlight);
        return this.ScheduleFlighttoDTO(scheduledFlight);
    }

    @Override
    public ScheduleFlightDTO updateScheduledFlight(ScheduleFlightDTO scheduleFlightDTO, BigInteger scheduleFlightId) {
        ScheduleFlight scheduleFlight = this.scheduleFlightDao.findById(scheduleFlightId).orElseThrow(()->new ResourceNotFoundException("Schedule Flight","Id",scheduleFlightId));
        scheduleFlight.setSourceAirport(scheduleFlightDTO.getSourceAirport());
        scheduleFlight.setDestinationAirport(scheduleFlightDTO.getDestinationAirport());
        scheduleFlight.setDepartureDateTime(scheduleFlightDTO.getDepartureDateTime());
        scheduleFlight.setDate(scheduleFlightDTO.getDate());
        scheduleFlight.setTicketCost(scheduleFlightDTO.getTicketCost());
        ScheduleFlight updatedScheduledFlight = this.scheduleFlightDao.save(scheduleFlight);
        ScheduleFlightDTO updatedScheduledFlightDTO = this.ScheduleFlighttoDTO(updatedScheduledFlight);
        return updatedScheduledFlightDTO;
    }

    @Override
    public ScheduleFlightDTO viewScheduledFlight(BigInteger scheduleFlightId) {
        ScheduleFlight scheduleFlight = this.scheduleFlightDao.findById(scheduleFlightId).orElseThrow(()->new ResourceNotFoundException("Schedule Flight","Flight",scheduleFlightId));
        return this.ScheduleFlighttoDTO(scheduleFlight);
    }

    @Override
    public List<ScheduleFlightDTO> viewAllScheduledFlights() {
        List<ScheduleFlight> scheduleFlights = this.scheduleFlightDao.findAll();
        List<ScheduleFlightDTO> scheduleFlightDTOS =scheduleFlights.stream().map(ScheduleFlight->ScheduleFlighttoDTO(ScheduleFlight)).collect(Collectors.toList());
        return scheduleFlightDTOS;
    }

    @Override
    public List<ScheduleFlightDTO> viewScheduledFlightByUser(BigInteger userId) {
        Users user = this.userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
        List<ScheduleFlight> scheduleFlight = this.scheduleFlightDao.findByUser(user);
        List<ScheduleFlightDTO> scheduleFlightDTOS = scheduleFlight.stream().map(ScheduleFlight->ScheduleFlighttoDTO(ScheduleFlight)).collect(Collectors.toList());
        return scheduleFlightDTOS;
    }

    @Override
    public void deleteScheduledFlight(BigInteger scheduleFlightId)
    {
        ScheduleFlight scheduleFlight = this.scheduleFlightDao.findById(scheduleFlightId).orElseThrow(()->new ResourceNotFoundException("Schedule Flight","Id",scheduleFlightId));
        this.scheduleFlightDao.delete(scheduleFlight);

    }

    @Override
    public List<ScheduleFlightDTO> searchScheduleFlights(String sourceAirport, String destinationAirport, String date)
    {
        List<ScheduleFlight> scheduleFlights = this.scheduleFlightDao.findBySourceAirportAndDestinationAirportAndDate(sourceAirport,destinationAirport,date);
        List<ScheduleFlightDTO> scheduleFlightDTOS = scheduleFlights.stream().map(ScheduleFlight->ScheduleFlighttoDTO(ScheduleFlight)).collect(Collectors.toList());
        return scheduleFlightDTOS;
    }

    private ScheduleFlight DTOtoScheduleFlight(ScheduleFlightDTO scheduleFlightDTO)
    {
        ScheduleFlight scheduleFlight = this.modelMapper.map(scheduleFlightDTO,ScheduleFlight.class);
        return scheduleFlight;
    }

    private ScheduleFlightDTO ScheduleFlighttoDTO(ScheduleFlight scheduleFlight)
    {
        ScheduleFlightDTO scheduleFlightDTO = this.modelMapper.map(scheduleFlight,ScheduleFlightDTO.class);
        return scheduleFlightDTO;
    }
}
