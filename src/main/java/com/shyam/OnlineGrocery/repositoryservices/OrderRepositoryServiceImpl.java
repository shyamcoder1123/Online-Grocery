package com.shyam.OnlineGrocery.repositoryservices;

import com.shyam.OnlineGrocery.dto.Grocery;
import com.shyam.OnlineGrocery.dto.Order;
import com.shyam.OnlineGrocery.exchange.OrderRequest;
import com.shyam.OnlineGrocery.models.CustomerEntity;
import com.shyam.OnlineGrocery.models.GroceryEntity;
import com.shyam.OnlineGrocery.models.OrderEntity;
import com.shyam.OnlineGrocery.repositories.CustomerRepository;
import com.shyam.OnlineGrocery.repositories.GroceryRepository;
import com.shyam.OnlineGrocery.repositories.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderRepositoryServiceImpl implements OrderRepositoryService{
    private final ModelMapper modelMapper;


    private final OrderRepository orderRepository;

    private final CustomerRepository customerRepository;

    private final GroceryRepository groceryRepository;

    public OrderRepositoryServiceImpl(ModelMapper modelMapper,
                                      OrderRepository orderRepository,
                                      CustomerRepository customerRepository,
                                      GroceryRepository groceryRepository) {
        this.modelMapper = modelMapper;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.groceryRepository = groceryRepository;
    }

    @Override
    public boolean deleteOrderById(Integer orderId) {
        orderRepository.deleteById(orderId);
        return true;
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderEntity -> modelMapper.map(orderEntity, Order.class))
                .toList();
    }

    @Override
    public Order createOrder(OrderRequest orderRequest) {
        CustomerEntity customer = customerRepository.findById(orderRequest.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        List<GroceryEntity> groceries = groceryRepository.findAllById(orderRequest.getGroceryIds());
        if (groceries.isEmpty()) {
            throw new IllegalArgumentException("No groceries found for the given IDs");
        }
        int totalPrice = 0;
        for(GroceryEntity grocery: groceries) totalPrice += grocery.getPrice();

        Order order = new Order(customer, groceries, orderRequest.getOrderDate(), totalPrice);
        OrderEntity entity = modelMapper.map(order, OrderEntity.class);

        OrderEntity saved = orderRepository.save(entity);

        return modelMapper.map(saved, Order.class);
    }

    @Override
    public Order updateOrderById(Integer orderId, OrderRequest orderRequest) {

        CustomerEntity customer = customerRepository.findById(orderRequest.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        List<GroceryEntity> groceries = groceryRepository.findAllById(orderRequest.getGroceryIds());
        if (groceries.isEmpty()) {
            throw new IllegalArgumentException("No groceries found for the given IDs");
        }
        int totalPrice = 0;
        for(GroceryEntity grocery: groceries) totalPrice += grocery.getPrice();

        Order order = new Order(customer, groceries, orderRequest.getOrderDate(), totalPrice);
        OrderEntity entity = modelMapper.map(order, OrderEntity.class);

        OrderEntity existingEntity = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Customer %d not found".formatted(orderId)));

        modelMapper.map(entity, existingEntity);

        OrderEntity updated = orderRepository.save(existingEntity);

        return modelMapper.map(updated, Order.class);
    }

    @Override
    public Order findOrderById(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(entity -> modelMapper.map(entity, Order.class))
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Customer %d not found".formatted(orderId)));
    }
}
