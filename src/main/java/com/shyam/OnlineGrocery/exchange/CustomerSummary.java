package com.shyam.OnlineGrocery.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSummary {
    private Integer id;
    private String name;
    private String email;
}
