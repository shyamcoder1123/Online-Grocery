package com.shyam.OnlineGrocery.repositoryservices;

import com.shyam.OnlineGrocery.dto.Customer;

import java.util.List;

public interface CustomerRepositoryService {
    List<Customer> findAllCustomers();

    Customer updateCustomerById(Integer customerId, Customer customer);

    Boolean deleteCustomerById(Integer customerId);

    Customer findCustomerById(Integer customerId);

    Customer createCustomer(Customer customer);
}
