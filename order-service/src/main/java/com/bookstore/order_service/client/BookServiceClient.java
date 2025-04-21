package com.bookstore.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "book-service")
public interface BookServiceClient {

    @GetMapping("/api/books/{id}")
    Map<String,Object> getBookById(@PathVariable("id") Long id );
}
