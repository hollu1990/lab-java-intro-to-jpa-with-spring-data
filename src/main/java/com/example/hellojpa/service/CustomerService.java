package com.example.hellojpa.service;

import com.example.hellojpa.model.Customer;
import com.example.hellojpa.model.CustomerStatus;
import com.example.hellojpa.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    // Constructor injection (no @Autowired)
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
}

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
    public List<Customer> getGoldCustomers() {
        return customerRepository.findByStatus(CustomerStatus.GOLD);
    }
    public List<Customer> getCustomerByStatus(CustomerStatus status) {
        return customerRepository.findByStatus(status);
}
}
