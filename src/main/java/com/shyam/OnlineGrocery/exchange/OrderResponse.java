package com.shyam.OnlineGrocery.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Integer orderId;
    private CustomerSummary customer;
    private List<GrocerySummary> groceries;
    private LocalDate orderDate;
    private int totalPrice;
}




