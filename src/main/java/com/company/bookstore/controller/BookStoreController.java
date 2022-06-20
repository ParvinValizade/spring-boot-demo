package com.company.bookstore.controller;

import com.company.bookstore.dto.BookOrderRequest;
import com.company.bookstore.model.Order;
import com.company.bookstore.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/bookstore")
public class BookStoreController {

    private final OrderService orderService;

    public BookStoreController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<String> helloKotlin(){
        return ResponseEntity.ok("Hello Kotlin");
    }

    @PostMapping
    public ResponseEntity<Order> putAnOrder(@RequestBody BookOrderRequest bookOrderRequest){
        Order order = orderService.putAnOrder(bookOrderRequest.getBookIdList(),bookOrderRequest.getUserName());

        return ResponseEntity.ok(order);
    }
}
