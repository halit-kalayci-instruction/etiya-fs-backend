package com.etiya.training.services.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductForAddDto {
    private String productName;
    private String quantityPerUnit;
    private int discontinued;
    private Short categoryId;
}
