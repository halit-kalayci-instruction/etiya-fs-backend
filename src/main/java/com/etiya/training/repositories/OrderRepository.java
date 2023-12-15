package com.etiya.training.repositories;

import com.etiya.training.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Short> {
}
