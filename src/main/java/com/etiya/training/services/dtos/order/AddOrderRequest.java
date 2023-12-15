package com.etiya.training.services.dtos.order;

import com.etiya.training.services.dtos.orderDetail.AddOrderDetailRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest
{
    private LocalDate requiredDate;
    private Short shipVia;
    private Float freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;
    private List<AddOrderDetailRequest> products;
}
