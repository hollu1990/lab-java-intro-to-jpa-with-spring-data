package com.example.hellojpa.configuration;

import com.example.hellojpa.model.Customer;
import com.example.hellojpa.model.CustomerStatus;
import com.example.hellojpa.model.Flight;
import com.example.hellojpa.model.FlightBooking;
import com.example.hellojpa.repository.CustomerRepository;
import com.example.hellojpa.repository.FlightBookingRepository;
import com.example.hellojpa.repository.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
}

    @Bean
    CommandLineRunner run(CustomerRepository customerRepo,
                          FlightRepository flightRepo,
                          FlightBookingRepository bookingRepo) {
        return args -> {
            // Sample Customers
            Customer alice = customerRepo.save(new Customer("Alice", CustomerStatus.GOLD, 120000));
            Customer bob = customerRepo.save(new Customer("Bob", CustomerStatus.SILVER, 85000));
            Customer charlie = customerRepo.save(new Customer("Charlie", CustomerStatus.ACTIVE, 30000));

            // Sample Flights
            Flight flight1 = flightRepo.save(new Flight("AB123", "Boeing 747", 300, 400));
            Flight flight2 = flightRepo.save(new Flight("XY456", "Airbus A320", 180, 600));
            Flight flight3 = flightRepo.save(new Flight("CD789", "Embraer 190", 100, 250));

            // Sample Bookings
            bookingRepo.save(new FlightBooking(alice.getCustomerId().intValue(), flight1.getFlightId().intValue()));
            bookingRepo.save(new FlightBooking(bob.getCustomerId().intValue(), flight2.getFlightId().intValue()));
            bookingRepo.save(new FlightBooking(charlie.getCustomerId().intValue(), flight3.getFlightId().intValue()));
        };
    }
}
