package com.shyam.OnlineGrocery.repositoryservices;

import com.shyam.OnlineGrocery.dto.Customer;
import com.shyam.OnlineGrocery.dto.Grocery;

import java.util.List;

public interface GroceryRepositoryService {
    List<Grocery> findAllGroceries();

    Grocery findGroceryById(Integer groceryId);

    Grocery updateGroceryById(Integer groceryId, Grocery grocery);

    boolean deleteGroceryById(Integer groceryId);

    Grocery createGrocery(Grocery grocery);
}
