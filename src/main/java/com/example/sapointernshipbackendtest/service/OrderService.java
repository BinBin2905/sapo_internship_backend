package com.example.sapointernshipbackendtest.service;

import com.example.sapointernshipbackendtest.model.Order;

public interface OrderService {

    Order processFlashSaleOrder(String userId, Long productId, int quantity);

}
