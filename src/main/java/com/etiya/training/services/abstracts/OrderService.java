package com.etiya.training.services.abstracts;

import com.etiya.training.services.dtos.order.AddOrderRequest;

public interface OrderService {
    void add(AddOrderRequest request);
}
