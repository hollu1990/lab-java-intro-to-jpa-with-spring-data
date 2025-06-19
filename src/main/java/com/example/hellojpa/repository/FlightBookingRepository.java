package com.example.hellojpa.repository;

import com.example.hellojpa.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Long> {
    List<FlightBooking> findByFlightId(Integer flightId);
    List<FlightBooking> findByCustomerId(Integer customerId);
}
