package com.shyam.OnlineGrocery.repositories;

import com.shyam.OnlineGrocery.models.GroceryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryRepository extends JpaRepository<GroceryEntity, Integer> {
}
