package com.example.sapointernshipbackendtest.repository;

import com.example.sapointernshipbackendtest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
