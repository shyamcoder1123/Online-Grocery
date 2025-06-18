package com.shyam.OnlineGrocery.services;

import com.shyam.OnlineGrocery.dto.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer getCustomerById(Integer customerId);

    Customer updateCustomerById(Integer customerId, Customer customer);

    boolean deleteCustomerById(Integer customerId);

    Customer createCustomer(Customer customer);
}
