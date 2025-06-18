package com.shyam.OnlineGrocery.repositoryservices;

import com.shyam.OnlineGrocery.dto.Customer;
import com.shyam.OnlineGrocery.models.CustomerEntity;
import com.shyam.OnlineGrocery.repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerRepositoryServiceImpl implements CustomerRepositoryService{

    private final ModelMapper modelMapper;


    private final CustomerRepository customerRepository;
    public CustomerRepositoryServiceImpl(ModelMapper modelMapper,
                                         CustomerRepository customerRepository) {
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerEntity -> modelMapper.map(customerEntity, Customer.class))
                .toList();
    }

    @Override
    public Customer updateCustomerById(Integer customerId, Customer customer) {
        CustomerEntity existingEntity = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer %d not found".formatted(customerId)));

        modelMapper.map(customer, existingEntity);

        CustomerEntity updated = customerRepository.save(existingEntity);

        return modelMapper.map(updated, Customer.class);
    }

    @Override
    public Boolean deleteCustomerById(Integer customerId) {
        customerRepository.deleteById(customerId);
        return true;
    }

    @Override
    public Customer findCustomerById(Integer customerId) {
        return customerRepository.findById(customerId)
                .map(entity -> modelMapper.map(entity, Customer.class))
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Customer %d not found".formatted(customerId)));
    }

    @Override
    public Customer createCustomer(Customer customer) {
        CustomerEntity entity = modelMapper.map(customer, CustomerEntity.class);

        CustomerEntity saved = customerRepository.save(entity);

        return modelMapper.map(saved, Customer.class);
    }
}
