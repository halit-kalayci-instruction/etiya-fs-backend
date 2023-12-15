package com.etiya.training.controllers;

import com.etiya.training.services.abstracts.OrderService;
import com.etiya.training.services.dtos.order.AddOrderRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/orders")
@AllArgsConstructor
public class OrdersController {
    private final OrderService orderService;
    @PostMapping
    public void add(@RequestBody AddOrderRequest addOrderRequest)
    {
        orderService.add(addOrderRequest);
    }
}
