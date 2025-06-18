package com.shyam.OnlineGrocery.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grocery {
    private String name;
    private String category;
    private int price;
    private int quantity;
}
