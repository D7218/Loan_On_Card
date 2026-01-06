package com.lon.custermerService.controller;

import com.lon.custermerService.entity.Customer;
import com.lon.custermerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping("")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

        Customer saved = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{id}")
    public Customer getCustomer( @PathVariable Long id){
        return customerService.getCustomer(id);
    }
    @PutMapping("/{id}")
    public Customer update( @PathVariable Long id, @RequestBody Customer customer){
        return customerService.updateCustomer(id, customer);
    }
    @GetMapping
    public List<Customer> getAll(){
        return customerService.getAll();
    }
}
   // WORKING ALL API
