package com.simsys.warehouse.service;
import com.simsys.warehouse.dto.RequestPurchaseOrderDTO;
import com.simsys.warehouse.entity.ProductDetailEntity;
import com.simsys.warehouse.entity.RequestPurchaseOrderEntity;
import com.simsys.warehouse.entity.SupplierEntity;
import com.simsys.warehouse.entity.UserEntity;
import com.simsys.warehouse.mapper.RequestPurchaseOrderMapper;
import com.simsys.warehouse.projection.ProductDetailProjection;
import com.simsys.warehouse.repository.RequestPurchaseOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RequestPurchaseOrderService {

    private final RequestPurchaseOrderRepository requestOrderRepository;

    private final ProductDetailService productDetailService;

    private final UserService userService;

    private final SupplierService supplierService;

    private final RequestPurchaseOrderMapper requestPurchaseOrderMapper;

    public RequestPurchaseOrderService(RequestPurchaseOrderRepository requestOrderRepository, ProductDetailService productDetailService, UserService userService, SupplierService supplierService, RequestPurchaseOrderMapper requestPurchaseOrderMapper) {
        this.requestOrderRepository = requestOrderRepository;
        this.productDetailService = productDetailService;
        this.userService = userService;
        this.supplierService = supplierService;
        this.requestPurchaseOrderMapper = requestPurchaseOrderMapper;
    }


    @Transactional
    public List<RequestPurchaseOrderDTO> createListRequestPurchaseOrdersFromVariants(int lowerBound, Integer supplierId, Integer userId, int totalQuantity) {
        // Lấy thông tin Supplier và User
        SupplierEntity supplier = supplierService.findSupplierById(supplierId)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        UserEntity user = userService.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Lấy danh sách ProductDetailProjection
        List<ProductDetailProjection> productDetails = productDetailService.getProductDetailsWithVariants(lowerBound);

        // Chuyển đổi ProductDetailProjection thành RequestPurchaseOrderDTO
        List<RequestPurchaseOrderDTO> requestPurchaseOrderDTOS = mapProductDetailsToDTOs(productDetails);

        // Tạo danh sách RequestPurchaseOrderEntity từ DTOs và lưu vào cơ sở dữ liệu
        List<RequestPurchaseOrderDTO> createdOrders = new ArrayList<>();
        for (RequestPurchaseOrderDTO dto : requestPurchaseOrderDTOS) {
            RequestPurchaseOrderEntity entity = createRequestPurchaseOrderEntity(dto, supplier, user, totalQuantity);
            requestOrderRepository.save(entity);
            createdOrders.add(requestPurchaseOrderMapper.mapToDTO(entity));
        }

        return createdOrders;
    }

    // Ánh xạ danh sách ProductDetailProjection sang RequestPurchaseOrderDTO
    private List<RequestPurchaseOrderDTO> mapProductDetailsToDTOs(List<ProductDetailProjection> productDetails) {
        return productDetails.stream()
                .map(detail -> {
                    RequestPurchaseOrderDTO dto = new RequestPurchaseOrderDTO();
                    dto.setProductDetailId(detail.getProductDetailId());
                    dto.setQuantity(detail.getTotalQuantity());
                    dto.setProductName(detail.getProductName());
                    dto.setColor(detail.getColorValues());
                    dto.setSize(detail.getSizeValues());
                    return dto;
                })
                .toList();
    }

    // Tạo RequestPurchaseOrderEntity từ DTO và các tham số khác
    private RequestPurchaseOrderEntity createRequestPurchaseOrderEntity(RequestPurchaseOrderDTO dto, SupplierEntity supplier, UserEntity user, int totalQuantity) {
        // Tìm ProductDetailEntity theo ID
        ProductDetailEntity productDetail = productDetailService.getProductById(dto.getProductDetailId())
                .orElseThrow(() -> new RuntimeException("ProductDetail not found"));

        // Tạo một thực thể mới
        RequestPurchaseOrderEntity entity = new RequestPurchaseOrderEntity();
        entity.setProductDetail(productDetail);
        entity.setSupplier(supplier);
        entity.setUser(user);

        // Gán các giá trị từ DTO và tham số
        entity.setQuantity(totalQuantity);
        entity.setCostPrice(dto.getCostPrice() != null ? dto.getCostPrice() : BigDecimal.valueOf(100));
        entity.setTotalAmount(dto.getTotalAmount());
        entity.setStatus(dto.getStatus() != null ? dto.getStatus() : "pending");
        entity.setOrderDate(dto.getOrderDate() != null ? dto.getOrderDate() : LocalDate.now());
        entity.setCreateDate(dto.getCreateDate() != null ? dto.getCreateDate() : LocalDate.now());
        entity.setNote(dto.getNote());
        entity.setSize(dto.getSize());
        entity.setColor(dto.getColor());
        entity.setDescription( "Auto-generated request order for " + dto.getProductName());
        entity.setEnable(true); // Mặc định là kích hoạt

        return entity;
    }



    public RequestPurchaseOrderDTO createRequestOrder(RequestPurchaseOrderDTO requestDto) {
        // Tìm Supplier
        SupplierEntity supplier = supplierService.findSupplierById(requestDto.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        // Tìm User
        UserEntity user = userService.findById(requestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Tìm Product Detail
        ProductDetailEntity productDetail = productDetailService.getProductById(requestDto.getProductDetailId())
                .orElseThrow(() -> new RuntimeException("Product detail not found"));

        // Tạo Entity từ DTO
        RequestPurchaseOrderEntity entity = requestPurchaseOrderMapper.mapToEntity(requestDto, supplier, user, productDetail);

        // Lưu vào database
        RequestPurchaseOrderEntity savedEntity = requestOrderRepository.save(entity);

        // Chuyển đổi sang DTO để trả về
        return requestPurchaseOrderMapper.mapToDTO(savedEntity);
    }


    public void deleteRequestPurchaseOrder(int requestPurchaseOrderID) {
        // Tìm RequestPurchaseOrderEntity theo ID
        RequestPurchaseOrderEntity requestOrder = requestOrderRepository.findById(requestPurchaseOrderID)
                .orElseThrow(() -> new RuntimeException("RequestPurchaseOrder not found with ID: " + requestPurchaseOrderID));

        // Cập nhật trạng thái isEnable thành false
        requestOrder.setEnable(false);

        // Lưu lại thay đổi vào cơ sở dữ liệu
        requestOrderRepository.save(requestOrder);
    }

    public RequestPurchaseOrderDTO updateRequestOrder(int requestPurchaseOrderID, RequestPurchaseOrderDTO updatedData) {
        // Tìm RequestPurchaseOrderEntity theo ID
        RequestPurchaseOrderEntity requestOrder = requestOrderRepository.findById(requestPurchaseOrderID)
                .orElseThrow(() -> new RuntimeException("RequestPurchaseOrder not found with ID: " + requestPurchaseOrderID));

        // Cập nhật các trường từ updatedData vào requestOrder
        if (updatedData.getSupplierId() != null) {
            SupplierEntity supplier = supplierService.findSupplierById(updatedData.getSupplierId())
                    .orElseThrow(() -> new RuntimeException("Supplier not found with ID: " + updatedData.getSupplierId()));
            requestOrder.setSupplier(supplier);
        }

        if (updatedData.getProductDetailId() != null) {
            ProductDetailEntity productDetail = productDetailService.getProductById(updatedData.getProductDetailId())
                    .orElseThrow(() -> new RuntimeException("ProductDetail not found with ID: " + updatedData.getProductDetailId()));
            requestOrder.setProductDetail(productDetail);
        }

        if (updatedData.getUserId() != null) {
            UserEntity user = userService.findById(updatedData.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found with ID: " + updatedData.getUserId()));
            requestOrder.setUser(user);
        }

        if (updatedData.getQuantity() != null) {
            requestOrder.setQuantity(updatedData.getQuantity());
        }

        if (updatedData.getCostPrice() != null) {
            requestOrder.setCostPrice(updatedData.getCostPrice());
        }

        if (updatedData.getTotalAmount() != null) {
            requestOrder.setTotalAmount(updatedData.getTotalAmount());
        }

        if (updatedData.getStatus() != null) {
            requestOrder.setStatus(updatedData.getStatus());
        }

        if (updatedData.getEnable() != null) {
            requestOrder.setEnable(updatedData.getEnable());
        }

        if (updatedData.getOrderDate() != null) {
            requestOrder.setOrderDate(updatedData.getOrderDate());
        }

        if (updatedData.getCreateDate() != null) {
            requestOrder.setCreateDate(updatedData.getCreateDate());
        }

        if (updatedData.getNote() != null) {
            requestOrder.setNote(updatedData.getNote());
        }

        if (updatedData.getSize() != null) {
            requestOrder.setSize(updatedData.getSize());
        }

        if (updatedData.getColor() != null) {
            requestOrder.setColor(updatedData.getColor());
        }

        if (updatedData.getDescription() != null) {
            requestOrder.setDescription(updatedData.getDescription());
        }

        // Lưu các thay đổi
        RequestPurchaseOrderEntity savedOrder = requestOrderRepository.save(requestOrder);

        // Chuyển đổi Entity đã lưu thành DTO và trả về
        return requestPurchaseOrderMapper.mapToDTO(savedOrder);
    }



    public Optional<RequestPurchaseOrderDTO> getRequestOrder(int requestID) {
        return requestOrderRepository.findById(requestID)
                .map(requestPurchaseOrderMapper::mapToDTO);
    }

    public List<RequestPurchaseOrderDTO> getAllRequestOrders() {
        return requestOrderRepository.findAll().stream()
                .map(requestPurchaseOrderMapper::mapToDTO)
                .toList();
    }

}
