package com.example.hellojpa.repository;

import com.example.hellojpa.model.Customer;
import com.example.hellojpa.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByStatus(CustomerStatus status);
}