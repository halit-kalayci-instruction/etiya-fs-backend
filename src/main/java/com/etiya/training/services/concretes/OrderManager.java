package com.etiya.training.services.concretes;

import com.etiya.training.entities.Order;
import com.etiya.training.repositories.OrderRepository;
import com.etiya.training.services.abstracts.OrderDetailService;
import com.etiya.training.services.abstracts.OrderService;
import com.etiya.training.services.dtos.order.AddOrderRequest;
import com.etiya.training.services.dtos.orderDetail.AddOrderDetailRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailService orderDetailService;
    // Transactional YAPI

    @Transactional
    @Override
    public void add(AddOrderRequest request) {
        // request => order map
        // Manual Mapping => Auto Mapping
        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setRequiredDate(request.getRequiredDate());
        order.setFreight(request.getFreight());
        order.setShipName(request.getShipName());
        order.setShipAddress(request.getShipAddress());
        order.setShipCity(request.getShipCity());
        order.setShipRegion(request.getShipRegion());
        order.setShipPostalCode(request.getShipPostalCode());
        order.setShipCountry(request.getShipCountry());

        orderRepository.save(order);
        for (AddOrderDetailRequest product: request.getProducts()) {
            orderDetailService.add(product, order);
        }
    }
}
