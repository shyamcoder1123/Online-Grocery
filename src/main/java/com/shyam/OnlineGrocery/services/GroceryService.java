package com.shyam.OnlineGrocery.services;

import com.shyam.OnlineGrocery.dto.Customer;
import com.shyam.OnlineGrocery.dto.Grocery;

import java.util.List;

public interface GroceryService {
    Grocery getGroceryById(Integer groceryId);
    Grocery updateGroceryById(Integer groceryId, Grocery grocery);
    boolean deleteGroceryById(Integer groceryId);
    Grocery createGrocery(Grocery grocery);

    List<Grocery> getAllGroceries();
}
