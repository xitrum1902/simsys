package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.RequestPurchaseOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledTask {

    @Autowired
    private ProductService productService;

    private final RequestPurchaseOrderService requestOrderService;

    public ScheduledTask(RequestPurchaseOrderService requestOrderService) {
        this.requestOrderService = requestOrderService;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    /**
     "0 0 0 * * ?":
     0 giây
     0 phút
     0 giờ (0h)
     * mỗi ngày
     * mỗi tháng
     ? bất kỳ ngày trong tuần
     **/
    @Scheduled(cron = "0 0 0 * * ?")
    public void autoCreateDailyRequestOrders() {
        int supplierId = 1;  // Hoặc lấy từ cấu hình
        int userId = 2;
        int limit = 20;
        int totalquantity = 100;

        List<RequestPurchaseOrderDTO> createdOrders = requestOrderService.createListRequestPurchaseOrdersFromVariants(limit, supplierId, userId,totalquantity);
    }

}
