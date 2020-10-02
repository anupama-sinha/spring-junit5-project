package com.anupama.junit5.service;

import com.anupama.junit5.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product addProduct(Product product);
    public Optional<Product> getProductById(Long id);
}
