package com.shyam.OnlineGrocery.services;

import com.shyam.OnlineGrocery.dto.Order;
import com.shyam.OnlineGrocery.exchange.OrderRequest;
import com.shyam.OnlineGrocery.repositoryservices.GroceryRepositoryService;
import com.shyam.OnlineGrocery.repositoryservices.OrderRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepositoryService orderRepositoryService;

    @Override
    public boolean deleteOrderById(Integer orderId) {
        return orderRepositoryService.deleteOrderById(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepositoryService.findAllOrders();
    }

    @Override
    public Order createOrder(OrderRequest orderRequest) {
        return orderRepositoryService.createOrder(orderRequest);
    }

    @Override
    public Order updateOrderById(Integer orderId, OrderRequest orderRequest) {
        return orderRepositoryService.updateOrderById(orderId, orderRequest);
    }

    @Override
    public Order getOrderById(Integer orderId) {
        return orderRepositoryService.findOrderById(orderId);
    }
}
