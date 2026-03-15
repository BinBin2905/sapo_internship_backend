package com.example.sapointernshipbackendtest.controller;

import com.example.sapointernshipbackendtest.dto.flashSaleDTO.FlashSaleRequestDTO;
import com.example.sapointernshipbackendtest.model.Order;
import com.example.sapointernshipbackendtest.service.serviceImpl.OrderServiceImpl;
import com.example.sapointernshipbackendtest.service.serviceImpl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/flash-sale/order")
public class FlashSaleController {

    private final ProductServiceImpl productService;
    private final OrderServiceImpl orderService;
    @PostMapping
    public ResponseEntity<?> order(@RequestBody FlashSaleRequestDTO request) {

        try {
            Order newOrder = orderService.processFlashSaleOrder(
                    request.userId,
                    request.productId,
                    request.quantity
            );
            return ResponseEntity.ok(newOrder);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}