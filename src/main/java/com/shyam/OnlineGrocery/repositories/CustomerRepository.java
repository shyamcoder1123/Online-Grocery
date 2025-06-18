package com.shyam.OnlineGrocery.repositories;

import com.shyam.OnlineGrocery.models.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

}
