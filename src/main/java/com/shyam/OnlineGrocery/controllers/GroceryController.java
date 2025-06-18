package com.shyam.OnlineGrocery.controllers;

import com.shyam.OnlineGrocery.dto.Customer;
import com.shyam.OnlineGrocery.dto.Grocery;
import com.shyam.OnlineGrocery.services.CustomerService;
import com.shyam.OnlineGrocery.services.GroceryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groceries")
public class GroceryController {
    private static final Logger log = LogManager.getLogger(GroceryController.class);

    @Autowired
    private GroceryService groceryService;

    @GetMapping
    public ResponseEntity<List<Grocery>> getAllGroceries(){
        List<Grocery> groceries = groceryService.getAllGroceries();
        return new ResponseEntity<>(groceries, HttpStatus.OK);
    }
    @GetMapping("/{groceryId}")
    public ResponseEntity<Grocery> getCustomerById(@PathVariable Integer groceryId){
        Grocery grocery = groceryService.getGroceryById(groceryId);
        return new ResponseEntity<>(grocery, HttpStatus.OK);
    }

    @PutMapping("/{groceryId}")
    public ResponseEntity<Grocery> updateCustomerById(@PathVariable Integer groceryId, @RequestBody Grocery grocery){
        Grocery grocery1 = groceryService.updateGroceryById(groceryId, grocery);
        return new ResponseEntity<>(grocery1, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{groceryId}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Integer groceryId){
        String message = "The grocery with the provided id: "+ groceryId+" doesn't exist";;
        if(groceryService.getGroceryById(groceryId) == null){
            new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        boolean isDeleted = groceryService.deleteGroceryById(groceryId);
        if(isDeleted) message = "grocery with id"+ groceryId+" deleted";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Grocery> createCustomer(@RequestBody Grocery grocery){
        Grocery createdGrocery = groceryService.createGrocery(grocery);
        return new ResponseEntity<>(createdGrocery, HttpStatus.CREATED);
    }
}
