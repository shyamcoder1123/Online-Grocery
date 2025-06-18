package com.shyam.OnlineGrocery.services;

import com.shyam.OnlineGrocery.dto.Grocery;
import com.shyam.OnlineGrocery.dto.Order;
import com.shyam.OnlineGrocery.exchange.OrderRequest;

import java.util.List;

public interface OrderService {

    boolean deleteOrderById(Integer orderId);

    List<Order> getAllOrders();

    Order createOrder(OrderRequest orderRequest);

    Order updateOrderById(Integer orderId, OrderRequest orderRequest);

    Order getOrderById(Integer orderId);
}
