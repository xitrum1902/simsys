package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.ProductDetailEntity;
import com.simsys.warehouse.entity.RequestOrderEntity;
import com.simsys.warehouse.projection.ProductDetailProjection;
import com.simsys.warehouse.repository.ProductDetailRepository;
import com.simsys.warehouse.repository.RequestOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class RequestOrderService {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private RequestOrderRepository requestOrderRepository;

    @Transactional
    public void createRequestOrdersForLowStock(int threshold) {
        List<ProductDetailProjection> lowStockProducts = productDetailRepository.findProductDetailsWithVariants(10);

        for (ProductDetailProjection productProjection : lowStockProducts) {
            ProductDetailEntity productDetail = new ProductDetailEntity();
            productDetail.setProductDetailId(productProjection.getProductDetailID());
            RequestOrderEntity requestOrder = new RequestOrderEntity();
            requestOrder.setProductDetail(productDetail);
            requestOrder.setQuantity(20); // Số lượng đặt hàng
            requestOrder.setCostPrice(new BigDecimal("100")); // Giá costprice giả định
            requestOrder.setTotalAmount(new BigDecimal("2000")); // Tổng số tiền
            requestOrder.setStatus(false); // Đặt hàng mới, chưa xử lý
            requestOrder.setOrderDate(LocalDate.now());
            requestOrder.setCreateDate(LocalDate.now());
            requestOrder.setDescription("Đặt hàng tự động do tồn kho thấp");

            requestOrderRepository.save(requestOrder);
        }
    }
}
