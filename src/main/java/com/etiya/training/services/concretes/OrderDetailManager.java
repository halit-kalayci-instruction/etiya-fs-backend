package com.etiya.training.services.concretes;

import com.etiya.training.core.utils.exceptions.types.BusinessException;
import com.etiya.training.entities.Order;
import com.etiya.training.entities.OrderDetail;
import com.etiya.training.entities.Product;
import com.etiya.training.repositories.OrderDetailRepository;
import com.etiya.training.services.abstracts.OrderDetailService;
import com.etiya.training.services.abstracts.ProductService;
import com.etiya.training.services.dtos.orderDetail.AddOrderDetailRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderDetailManager implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private final ProductService productService;
    @Override
    public void add(AddOrderDetailRequest request, Order order)
    {
        Product product = productService
                .getById(request.getProductId())
                .orElseThrow( () -> new BusinessException("Böyle bir ürün bulunamadı.") );
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProduct(product);
        orderDetail.setQuantity(request.getQuantity());
        orderDetail.setUnitPrice(product.getUnitPrice());

        // Float, Long, Double, Integer => 1 => integer, 1F float, 1L long, 1D double
        orderDetail.setDiscount(0F);
        orderDetail.setOrder(order);

        orderDetailRepository.save(orderDetail);
    }
}
