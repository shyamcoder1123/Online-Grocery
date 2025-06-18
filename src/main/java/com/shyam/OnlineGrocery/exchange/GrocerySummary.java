package com.shyam.OnlineGrocery.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrocerySummary {
    private Integer id;
    private String name;
    private int price;
}
