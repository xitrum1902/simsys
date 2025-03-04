package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.RequestOrderDTO;
import com.simsys.warehouse.entity.ProductDetailEntity;
import com.simsys.warehouse.entity.RequestOrderEntity;
import com.simsys.warehouse.entity.SupplierEntity;
import com.simsys.warehouse.entity.UserEntity;
import com.simsys.warehouse.repository.ProductDetailRepository;
import com.simsys.warehouse.repository.RequestOrderRepository;
import com.simsys.warehouse.repository.SupplierRepository;
import com.simsys.warehouse.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RequestOrderService {

    private final RequestOrderRepository requestOrderRepository;
    private final ProductDetailRepository productDetailRepository;
    private final SupplierRepository supplierRepository;
    private final UserRepository userRepository;

    public RequestOrderService(RequestOrderRepository requestOrderRepository,
                               ProductDetailRepository productDetailRepository,
                               SupplierRepository supplierRepository,
                               UserRepository userRepository) {
        this.requestOrderRepository = requestOrderRepository;
        this.productDetailRepository = productDetailRepository;
        this.supplierRepository = supplierRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void createRequestOrders(List<RequestOrderDTO> requestOrderDTOs, Integer supplierId, Integer userId) {
        Optional<SupplierEntity> supplierOpt = supplierRepository.findById(supplierId);
        Optional<UserEntity> userOpt = userRepository.findById(userId);

        if (supplierOpt.isEmpty() || userOpt.isEmpty()) {
            throw new RuntimeException("Supplier or User not found");
        }

        SupplierEntity supplier = supplierOpt.get();
        UserEntity user = userOpt.get();

        for (RequestOrderDTO dto : requestOrderDTOs) {
            Optional<ProductDetailEntity> productDetailOpt = productDetailRepository.findById(dto.getProductDetailId());

            if (productDetailOpt.isPresent()) {
                ProductDetailEntity productDetail = productDetailOpt.get();

                RequestOrderEntity requestOrder = new RequestOrderEntity();
                requestOrder.setProductDetail(productDetail);
                requestOrder.setSupplier(supplier);
                requestOrder.setUser(user);
                requestOrder.setQuantity(dto.getTotalQuantity());
                requestOrder.setCostPrice(BigDecimal.valueOf(100)); // Giá nhập (có thể tính toán sau)
                requestOrder.setTotalAmount(requestOrder.getCostPrice().multiply(BigDecimal.valueOf(dto.getTotalQuantity())));
                requestOrder.setStatus(false); // Chưa duyệt
                requestOrder.setOrderDate(LocalDate.now());
                requestOrder.setCreateDate(LocalDate.now());
                requestOrder.setDescription("Auto-generated request order for " + dto.getProductName());

                requestOrderRepository.save(requestOrder);
            }
        }
    }
}
