package com.shyam.OnlineGrocery.services;

import com.shyam.OnlineGrocery.dto.Customer;
import com.shyam.OnlineGrocery.repositoryservices.CustomerRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepositoryService customerRepositoryService;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepositoryService.findAllCustomers();
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        return customerRepositoryService.findCustomerById(customerId);
    }

    @Override
    public Customer updateCustomerById(Integer customerId, Customer customer) {
        return customerRepositoryService.updateCustomerById(customerId, customer);
    }

    @Override
    public boolean deleteCustomerById(Integer customerId) {
        return customerRepositoryService.deleteCustomerById(customerId);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepositoryService.createCustomer(customer);
    }
}
