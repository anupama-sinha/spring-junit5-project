package com.anupama.junit5.service.serviceimpl;

import com.anupama.junit5.model.Product;
import com.anupama.junit5.repository.ProductRepository;
import com.anupama.junit5.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Cacheable(value="productCache")
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        logger.info("Received Products : {}",products.toString());        
        return products;
    }

    @Override
    @Transactional
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

}
