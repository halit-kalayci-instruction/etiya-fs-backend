package com.etiya.training.services.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListProductResponse {
    private Short productId;
    private String productName;
}
