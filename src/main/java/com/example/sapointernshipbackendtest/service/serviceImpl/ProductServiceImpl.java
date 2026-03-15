package com.example.sapointernshipbackendtest.service.serviceImpl;

import com.example.sapointernshipbackendtest.dto.productDTO.ProductRequestDTO;
import com.example.sapointernshipbackendtest.model.Product;
import com.example.sapointernshipbackendtest.repository.ProductRepository;
import com.example.sapointernshipbackendtest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public Product create(ProductRequestDTO product) {
        Product p = new Product();
        p.setName(product.name);
        p.setStock(product.stock);
        return repository.save(p);
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> getById(Long id) {
        return Optional.of(repository.findById(id).orElseThrow());
    }

    @Override
    public Product update(Long id,ProductRequestDTO product) {
        Optional<Product> p = Optional.of(getById(id).orElseThrow());

        p.get().setName(product.name);
        p.get().setStock(product.stock);

        return repository.save(p.get());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
