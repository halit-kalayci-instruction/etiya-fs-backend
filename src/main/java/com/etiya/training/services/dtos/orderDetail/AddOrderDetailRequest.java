package com.etiya.training.services.dtos.orderDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderDetailRequest {
    private Short productId;
    private Short quantity;
}
