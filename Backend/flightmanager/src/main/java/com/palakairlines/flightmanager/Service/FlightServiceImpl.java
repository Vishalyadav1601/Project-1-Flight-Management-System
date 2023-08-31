package com.palakairlines.flightmanager.Service;

import com.palakairlines.flightmanager.DTO.FlightDTO;
import com.palakairlines.flightmanager.Exceptions.ResourceNotFoundException;
import com.palakairlines.flightmanager.Model.Flight;
import com.palakairlines.flightmanager.Model.ScheduleFlight;
import com.palakairlines.flightmanager.dao.FlightDao;
import com.palakairlines.flightmanager.dao.ScheduleFlightDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService{
    @Autowired
    private FlightDao flightDao;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ScheduleFlightDao scheduleFlightDao;
    @Override
    public FlightDTO addFlight(FlightDTO flightDTO,BigInteger scheduleFlightId) {
        ScheduleFlight scheduleFlight = this.scheduleFlightDao.findById(scheduleFlightId).orElseThrow(()->new ResourceNotFoundException("Schedule Flight","Id",scheduleFlightId));
        Flight flight = this.DTOtoFlight(flightDTO);
        flight.setScheduleFlight(scheduleFlight);
        Flight addedFlight = this.flightDao.save(flight);
        return this.FlightToDTO(addedFlight);
    }

    @Override
    public FlightDTO updateFlight(FlightDTO flightDTO,BigInteger flightNumber) {
        Flight flight = this.flightDao.findById(flightNumber).orElseThrow(()->new ResourceNotFoundException("Fligh","Number",flightNumber));
        flight.setFlightModel(flightDTO.getFlightModel());
        flight.setCarrierName(flightDTO.getCarrierName());
        flight.setSeatCapacity(flightDTO.getSeatCapacity());
        Flight updatedFlight = this.flightDao.save(flight);
        return this.FlightToDTO(updatedFlight);
    }

    @Override
    public void deleteFlight(BigInteger flightNumber) {
        Flight flight = this.flightDao.findById(flightNumber).orElseThrow(()->new ResourceNotFoundException("Flight","Number",flightNumber));
        this.flightDao.delete(flight);

    }

    @Override
    public FlightDTO getFlight(BigInteger flightNumber) {
        Flight flight = this.flightDao.findById(flightNumber).orElseThrow(()->new ResourceNotFoundException("Flight","Number",flightNumber));
        return this.FlightToDTO(flight);
    }

    @Override
    public List<FlightDTO> getAllFlights() {
        List<Flight> flights = this.flightDao.findAll();
        List<FlightDTO> flightDTOS = flights.stream().map(Flight->FlightToDTO(Flight)).collect(Collectors.toList());
        return flightDTOS;
    }

    @Override
    public FlightDTO getFlightByScheduleFlight(BigInteger scheduleFlightId)
    {
        ScheduleFlight scheduleFlight = this.scheduleFlightDao.findById(scheduleFlightId).orElseThrow(()->new ResourceNotFoundException("Schedule Flight","Id",scheduleFlightId));
        Flight flight = this.flightDao.findByScheduleFlight(scheduleFlight);
        return this.FlightToDTO(flight);
    }

    private Flight DTOtoFlight(FlightDTO flightDTO)
    {
        Flight flight = this.modelMapper.map(flightDTO,Flight.class);
        return flight;
    }

    private FlightDTO FlightToDTO(Flight flight)
    {
        FlightDTO flightDTO = this.modelMapper.map(flight,FlightDTO.class);
                return flightDTO;
    }
}
