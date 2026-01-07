package com.lon.custermerService.service;

import com.lon.custermerService.entity.Customer;
import com.lon.custermerService.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

     public Customer createCustomer(Customer customer){
         customer.setId(null);
         return repository.save(customer);

   }
   public Customer getCustomer( Long id){
       return repository.findById(id)
               .orElseThrow(()-> new RuntimeException("Customer not found"));
   }
   public Customer updateCustomer(Long id, Customer customer){
       Customer existing = getCustomer(id);
       existing.setName(customer.getName());
       existing.setEmail(customer.getEmail());
       existing.setMobile(customer.getMobile());
       return repository.save(existing);
   }
   public List<Customer> getAll(){
         return repository.findAll();

   }
}
// all clear apis totally wor