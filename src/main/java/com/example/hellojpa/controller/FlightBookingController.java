package com.example.hellojpa.controller;


import com.example.hellojpa.model.FlightBooking;
import com.example.hellojpa.service.FlightBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/flight-bookings")
public class FlightBookingController {
    private final FlightBookingService flightBookingService;

    // ✅ Constructor injection (no @Autowired)
    public FlightBookingController(FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }

    // ✅ Get all bookings
    @GetMapping
    public ResponseEntity<List<FlightBooking>> getAllBookings() {
        List<FlightBooking> bookings = flightBookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    // ✅ Get bookings by flight ID
    @GetMapping("/flight/{flightId}")
    public ResponseEntity<List<FlightBooking>> getBookingsByFlightId(@PathVariable Integer flightId) {
        List<FlightBooking> bookings = flightBookingService.getBookingsByFlightId(flightId);
        return ResponseEntity.ok(bookings);
    }
}
