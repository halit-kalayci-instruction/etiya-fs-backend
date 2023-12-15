package com.etiya.training.services.abstracts;

import com.etiya.training.entities.Order;
import com.etiya.training.services.dtos.orderDetail.AddOrderDetailRequest;

public interface OrderDetailService {
    void add(AddOrderDetailRequest request, Order order);
}
