package com.epam.engx.cleancode.naming.task1.delivery;

import com.epam.engx.cleancode.naming.task1.OrderService;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.*;

import java.util.List;

public class DeliveryOrderService implements OrderService {

    private DeliveryService mDeliveryService;

    private OrderFulfilmentService mOrderFulfilmentService;

    public void submit(Order pOrder) {
        if (mDeliveryService.isDeliverable(pOrder)) {
            List<Product> products = pOrder.getProducts();
            mOrderFulfilmentService.fulfilProducts(products);
        } else {
            throw new NotDeliverableOrderException();
        }
    }

    public void setDeliveryService(DeliveryService pDeliveryService) {
        this.mDeliveryService = pDeliveryService;
    }

    public void setOrderFulfilmentService(OrderFulfilmentService pOrderFulfilmentService) {
        this.mOrderFulfilmentService = pOrderFulfilmentService;
    }
}
