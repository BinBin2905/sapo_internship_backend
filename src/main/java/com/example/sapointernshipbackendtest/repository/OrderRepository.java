package com.example.sapointernshipbackendtest.repository;

import com.example.sapointernshipbackendtest.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query("SELECT COALESCE(SUM(oi.quantity), 0) " +
            "FROM OrderItem oi " +
            "JOIN oi.order o " +
            "WHERE o.userId = :userId AND oi.product.id = :productId")
    Integer countTotalQuantityByUserIdAndProductId(@Param("userId") String userId,
                                                   @Param("productId") Long productId);
}
