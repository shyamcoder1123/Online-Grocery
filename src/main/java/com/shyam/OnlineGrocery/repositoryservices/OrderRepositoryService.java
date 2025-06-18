package com.shyam.OnlineGrocery.repositoryservices;

import com.shyam.OnlineGrocery.dto.Order;
import com.shyam.OnlineGrocery.exchange.OrderRequest;

import java.util.List;

public interface OrderRepositoryService {
    boolean deleteOrderById(Integer orderId);

    List<Order> findAllOrders();

    Order createOrder(OrderRequest orderRequest);

    Order updateOrderById(Integer orderId, OrderRequest orderRequest);

    Order findOrderById(Integer orderId);
}
