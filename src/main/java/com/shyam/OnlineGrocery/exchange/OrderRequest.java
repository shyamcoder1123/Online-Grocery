package com.shyam.OnlineGrocery.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    Integer customerId;
    List<Integer> groceryIds;
    LocalDate orderDate;
}
