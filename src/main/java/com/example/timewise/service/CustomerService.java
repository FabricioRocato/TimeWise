package com.example.timewise.service;

import com.example.timewise.model.Customer;
import com.example.timewise.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public void save(Customer customer) {
        repository.save(customer);

    }
    public Page<Customer> findByNamev2(Integer pageNumber, Integer pageSize, String searchTerm){
        searchTerm = Objects.nonNull(searchTerm) ? searchTerm : "";
        return repository.findByNamev2("%"+searchTerm+"%", PageRequest.of(pageNumber, pageSize));
    }

    public Customer findCustomerId(Long id){
        return repository.findCustomerId(id);
    }

    public void deleteById(Long customerId) {
        repository.deleteById(customerId);
    }
}