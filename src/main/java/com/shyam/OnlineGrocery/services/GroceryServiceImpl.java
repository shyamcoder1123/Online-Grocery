package com.shyam.OnlineGrocery.services;

import com.shyam.OnlineGrocery.dto.Customer;
import com.shyam.OnlineGrocery.dto.Grocery;
import com.shyam.OnlineGrocery.repositoryservices.GroceryRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryServiceImpl implements GroceryService{
    @Autowired
    private GroceryRepositoryService groceryRepositoryService;

    @Override
    public List<Grocery> getAllGroceries() {
        return groceryRepositoryService.findAllGroceries();
    }

    @Override
    public Grocery getGroceryById(Integer groceryId) {
        return groceryRepositoryService.findGroceryById(groceryId);
    }

    @Override
    public Grocery updateGroceryById(Integer groceryId, Grocery grocery) {
        return groceryRepositoryService.updateGroceryById(groceryId, grocery);
    }

    @Override
    public boolean deleteGroceryById(Integer groceryId) {
        return groceryRepositoryService.deleteGroceryById(groceryId);
    }

    @Override
    public Grocery createGrocery(Grocery grocery) {
        return groceryRepositoryService.createGrocery(grocery);
    }
}
