package com.shyam.OnlineGrocery.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_groceries",                    // join‑table name
            joinColumns        = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "grocery_id")
    )
    private List<GroceryEntity>groceries;
    private LocalDate orderDate;
    private int totalPrice;
}
