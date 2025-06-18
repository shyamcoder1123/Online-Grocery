package com.shyam.OnlineGrocery.controllers;

import com.shyam.OnlineGrocery.dto.Grocery;
import com.shyam.OnlineGrocery.dto.Order;
import com.shyam.OnlineGrocery.exchange.OrderRequest;
import com.shyam.OnlineGrocery.services.GroceryService;
import com.shyam.OnlineGrocery.services.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private static final Logger log = LogManager.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer orderId){
        Order order = orderService.getOrderById(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateOrderById(@PathVariable Integer orderId, @RequestBody OrderRequest orderRequest){
        Order order = orderService.updateOrderById(orderId, orderRequest);
        return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrderById(@PathVariable Integer orderId){
        String message = "The order with the provided id: "+ orderId+" doesn't exist";;
        if(orderService.getOrderById(orderId) == null){
            new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        boolean isDeleted = orderService.deleteOrderById(orderId);
        if(isDeleted) message = "order with id"+ orderId+" deleted";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest){
        Order createdOrder = orderService.createOrder(orderRequest);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }
}
