package com.example.timewise.api;

import com.example.timewise.model.Customer;
import com.example.timewise.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("customer")
public class CustomerApi {

    @Autowired
    private CustomerService service;


    @PostMapping
    public String save(@RequestBody Customer customer) {
        service.save(customer);
        return "Customer saved with success";
    }
    @GetMapping("/v2")
    public Page<Customer> findByNamev2(@RequestParam String searchTerm,
                                       @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                       @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return service.findByNamev2(pageNumber, pageSize, searchTerm);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity findbyId(@PathVariable("id") Long id) {
        return  ResponseEntity.ok(service.findCustomerId(id));
    }
    @RequestMapping(value = "/{customerId}", method = GET)
    public String deleteCustomer(@PathVariable Long customerId) {
        service.deleteById(customerId);
        return "Customer " + customerId + " Was deleted";
    }
}