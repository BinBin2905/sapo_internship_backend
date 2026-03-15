package com.example.sapointernshipbackendtest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/flash-sale/order")
public class FlashSaleController {

    @PostMapping
    public ResponseEntity<?> order(){
        return ResponseEntity.ok();
    }

}
