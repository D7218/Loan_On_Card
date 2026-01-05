package com.lon.custermerService.controller;

import com.lon.custermerService.entity.Customer;
import com.lon.custermerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping
    public Customer create(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }
    @GetMapping("/{id}")
    public Customer getCustomer( @PathVariable Long id){
        return customerService.getCustomer(id);
    }
    @PutMapping("/{id}")
    public Customer update( @PathVariable Long id, @RequestBody Customer customer){
        return customerService.updateCustomer(id, customer);
    }
}
