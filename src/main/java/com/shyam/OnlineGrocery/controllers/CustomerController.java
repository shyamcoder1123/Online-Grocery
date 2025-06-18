package com.shyam.OnlineGrocery.controllers;

import com.shyam.OnlineGrocery.dto.Customer;
import com.shyam.OnlineGrocery.services.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private static final Logger log = LogManager.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer customerId){
        Customer customer = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomerById(@PathVariable Integer customerId, @RequestBody Customer customer){
        Customer customer1 = customerService.updateCustomerById(customerId, customer);
        return new ResponseEntity<>(customer1, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Integer customerId){
        String message = "The customer with the provided id: "+ customerId+" doesn't exist";;
        if(customerService.getCustomerById(customerId) == null){
            new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        boolean isDeleted = customerService.deleteCustomerById(customerId);
        if(isDeleted) message = "Customer with id"+ customerId+" deleted";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer createdCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }
}
