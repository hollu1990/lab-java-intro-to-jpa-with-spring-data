package com.example.hellojpa.repository;

import com.example.hellojpa.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {}

