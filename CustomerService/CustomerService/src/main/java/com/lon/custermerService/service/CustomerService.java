package com.lon.custermerService.service;

import com.lon.custermerService.CustomerServiceApplication;
import com.lon.custermerService.entity.Customer;
import com.lon.custermerService.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

   public Customer createCustomer(Customer customer){
       customer.setKycStatus("PENDING");
       return customerRepository.save(customer);
   }
   public Customer getCustomer(Long id){
       return customerRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("Customer not found"));
   }
   public Customer updateCustomer(Long id, Customer customer){
       Customer existing = getCustomer(id);
       existing.setName(customer.getName());
       existing.setEmail(customer.getEmail());
       existing.setMobile(customer.getMobile());
       return customerRepository.save(existing);
   }
}
