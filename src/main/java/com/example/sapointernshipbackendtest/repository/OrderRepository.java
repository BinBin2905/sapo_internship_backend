package com.example.sapointernshipbackendtest.repository;

import com.example.sapointernshipbackendtest.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
