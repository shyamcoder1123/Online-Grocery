package com.shyam.OnlineGrocery.dto;

import com.shyam.OnlineGrocery.models.CustomerEntity;
import com.shyam.OnlineGrocery.models.GroceryEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private CustomerEntity customer;
    private List<GroceryEntity> groceries;
    private LocalDate orderDate;
    private int totalPrice;
}
