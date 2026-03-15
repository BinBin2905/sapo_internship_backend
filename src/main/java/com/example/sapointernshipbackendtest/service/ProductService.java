package com.example.sapointernshipbackendtest.service;

import com.example.sapointernshipbackendtest.dto.productDTO.ProductRequestDTO;
import com.example.sapointernshipbackendtest.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    Product create(ProductRequestDTO product);

    List<Product> getAll();

    Optional<Product> getById(Long id);

    Product update(Long id , ProductRequestDTO product);

    void delete(Long id);
}
