package com.example.hellojpa.service;

import com.example.hellojpa.model.FlightBooking;
import com.example.hellojpa.repository.FlightBookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FlightBookingService {

    private final FlightBookingRepository flightBookingRepository;

    public FlightBookingService(FlightBookingRepository flightBookingRepository) {
        this.flightBookingRepository = flightBookingRepository;
    }
    public List<FlightBooking> getAllBookings() {
        return flightBookingRepository.findAll();
    }
    public List<FlightBooking> getBookingsByFlightId(Integer flightId) {
        return flightBookingRepository.findByFlightId(flightId);
    }
    public List<FlightBooking> getBookingsByCustomerId(Integer customerId) {
        return flightBookingRepository.findByCustomerId(customerId);
    }
}
