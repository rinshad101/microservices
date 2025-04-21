package com.bookstore.order_service.service;

import com.bookstore.order_service.client.BookServiceClient;
import com.bookstore.order_service.client.UserServiceClient;
import com.bookstore.order_service.model.Order;
import com.bookstore.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final BookServiceClient bookClient;
    private final UserServiceClient userClient;

    public OrderService(OrderRepository orderRepository, BookServiceClient bookClient, UserServiceClient userClient) {
        this.orderRepository = orderRepository;
        this.bookClient = bookClient;
        this.userClient = userClient;
    }

    public Order createOrder(Long bookId, Long userId) {
        Map<String, Object> book = bookClient.getBookById(bookId);
        Map<String, Object> user = userClient.getUserById(userId);

        Order order = Order.builder()
                .bookId(bookId)
                .userId(userId)
                .bookTitle((String) book.get("title"))
                .userName((String) user.get("name"))
                .build();

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
