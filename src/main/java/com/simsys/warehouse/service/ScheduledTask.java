package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledTask {

    @Autowired
    private ProductService productService;

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
    public void runDailyTask() {
        List<ProductEntity> lowStockProducts = productService.getLowStockProducts(30);
        if (!lowStockProducts.isEmpty()) {
            System.out.println("Những sản phẩm có số lượng dưới 30:");
            lowStockProducts.forEach(System.out::println);

            System.out.println("Gợi ý: Vui lòng nhập thêm hàng cho các sản phẩm trên.");
        } else {
            System.out.println("Tất cả sản phẩm đều có số lượng đủ (>= 30).");
        }
    }

}
