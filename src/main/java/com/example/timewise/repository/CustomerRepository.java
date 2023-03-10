package com.example.timewise.repository;

import com.example.timewise.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select c from Customer c where c.name ilike :searchTerm")
    Page<Customer> findByNamev2(@Param("searchTerm") String searchTerm, Pageable pageable);

    @Query(value ="select c from Customer c where c.id = :id")
    Customer findCustomerId(@Param("id") Long id);
}

