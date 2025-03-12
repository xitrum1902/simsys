package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.RequestOrderDTO;
import com.simsys.warehouse.entity.ProductDetailEntity;
import com.simsys.warehouse.entity.RequestOrderEntity;
import com.simsys.warehouse.entity.SupplierEntity;
import com.simsys.warehouse.entity.UserEntity;
import com.simsys.warehouse.projection.ProductDetailProjection;
import com.simsys.warehouse.repository.RequestOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RequestOrderService {

    private final RequestOrderRepository requestOrderRepository;

    private final ProductDetailService productDetailService;

    private final UserService userService;

    private final SupplierService supplierService;

    public RequestOrderService(RequestOrderRepository requestOrderRepository, ProductDetailService productDetailService, UserService userService, SupplierService supplierService) {
        this.requestOrderRepository = requestOrderRepository;
        this.productDetailService = productDetailService;
        this.userService = userService;
        this.supplierService = supplierService;
        ;
    }

    @Transactional
    public List<RequestOrderDTO> createRequestOrdersFromVariants(int lowerBound, Integer supplierId, Integer userId, int totalquantity) {
        Optional<SupplierEntity> supplierOpt = supplierService.findSupplierById(supplierId);
        Optional<UserEntity> userOpt = userService.findById(userId);

        if (supplierOpt.isEmpty() || userOpt.isEmpty()) {
            throw new RuntimeException("Supplier or User not found");
        }

        SupplierEntity supplier = supplierOpt.get();
        UserEntity user = userOpt.get();

        List<ProductDetailProjection> productDetails = productDetailService.getProductDetailsWithVariants(lowerBound);

        List<RequestOrderDTO> requestOrderDTOs = productDetails.stream().map(detail -> {
            RequestOrderDTO dto = new RequestOrderDTO();
            dto.setProductDetailId(detail.getProductDetailId());
            dto.setTotalQuantity(detail.getTotalQuantity());
            dto.setProductName(detail.getProductName());
            dto.setColorValues(detail.getColorValues());
            dto.setSizeValues(detail.getSizeValues());
            return dto;
        }).collect(Collectors.toList());

        List<RequestOrderDTO> createdOrders = new ArrayList<>();

        for (RequestOrderDTO dto : requestOrderDTOs) {
            Optional<ProductDetailEntity> productDetailOpt = productDetailService.findById(dto.getProductDetailId());

            if (productDetailOpt.isPresent()) {
                ProductDetailEntity productDetail = productDetailOpt.get();
                RequestOrderEntity requestOrder = new RequestOrderEntity();
                requestOrder.setProductDetail(productDetail);
                requestOrder.setSupplier(supplier);
                requestOrder.setUser(user);
                requestOrder.setQuantity(totalquantity);
                requestOrder.setCostPrice(BigDecimal.valueOf(100));
                requestOrder.setTotalAmount(requestOrder.getCostPrice().multiply(BigDecimal.valueOf(dto.getTotalQuantity())));
                requestOrder.setStatus(false);
                requestOrder.setOrderDate(LocalDate.now());
                requestOrder.setCreateDate(LocalDate.now());
                requestOrder.setDescription("Auto-generated request order for " + dto.getProductName());

                RequestOrderEntity savedOrder = requestOrderRepository.save(requestOrder);

                RequestOrderDTO responseDTO = new RequestOrderDTO();
                responseDTO.setRequestOrderId(savedOrder.getRequestOrderId());
                responseDTO.setProductDetailId(savedOrder.getProductDetail().getProductDetailId());
                responseDTO.setTotalQuantity(savedOrder.getQuantity());
                responseDTO.setProductName(dto.getProductName());
                responseDTO.setSupplierId(savedOrder.getSupplier().getSupplierId());
                responseDTO.setUserId(savedOrder.getUser().getUserId());
                responseDTO.setCostPrice(savedOrder.getCostPrice());
                responseDTO.setTotalAmount(savedOrder.getTotalAmount());
                responseDTO.setStatus(savedOrder.getStatus());
                responseDTO.setOrderDate(savedOrder.getOrderDate());
                responseDTO.setCreateDate(savedOrder.getCreateDate());
                responseDTO.setColorValues(dto.getColorValues());
                responseDTO.setSizeValues(dto.getSizeValues());

                createdOrders.add(responseDTO);
            }
        }
        return createdOrders;
    }


    public List<RequestOrderDTO> createRequestOrder(RequestOrderDTO requestDto) {
        List<RequestOrderDTO> createdOrders = new ArrayList<>();

        SupplierEntity supplier = supplierService.findSupplierById(requestDto.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        // Tìm User
        UserEntity user = userService.findById(requestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Tìm Product Detail
        ProductDetailEntity productDetail = productDetailService.findById(requestDto.getProductDetailId())
                .orElseThrow(() -> new RuntimeException("Product detail not found"));

        // Tạo Request Order Entity
        RequestOrderEntity requestOrder = new RequestOrderEntity();
        requestOrder.setProductDetail(productDetail);
        requestOrder.setSupplier(supplier);
        requestOrder.setUser(user);
        requestOrder.setQuantity(requestDto.getTotalQuantity());
        requestOrder.setCostPrice(BigDecimal.valueOf(100));
        requestOrder.setTotalAmount(requestOrder.getCostPrice().multiply(BigDecimal.valueOf(requestDto.getTotalQuantity())));
        requestOrder.setStatus(false);
        requestOrder.setOrderDate(LocalDate.now());
        requestOrder.setCreateDate(LocalDate.now());
        requestOrder.setDescription("Request Order for " + requestDto.getProductName());

        //  Lưu vào database
        RequestOrderEntity savedOrder = requestOrderRepository.save(requestOrder);

        // Chuyển thành DTO để trả về
        createdOrders.add(mapToDTO(savedOrder));

        return createdOrders;
    }

    // Mapping từ Entity → DTO
    private RequestOrderDTO mapToDTO(RequestOrderEntity order) {
        RequestOrderDTO dto = new RequestOrderDTO();
        dto.setRequestOrderId(order.getRequestOrderId());
        dto.setProductDetailId(order.getProductDetail().getProductDetailId());
        dto.setTotalQuantity(order.getQuantity());
        dto.setProductName(order.getProductDetail().getProduct().getName());
        dto.setSupplierId(order.getSupplier().getSupplierId());
        dto.setUserId(order.getUser().getUserId());
        dto.setCostPrice(order.getCostPrice());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setStatus(order.getStatus());
        dto.setOrderDate(order.getOrderDate());
        dto.setCreateDate(order.getCreateDate());
        return dto;
    }
}
