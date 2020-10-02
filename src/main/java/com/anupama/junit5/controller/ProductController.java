package com.anupama.junit5.controller;

import com.anupama.junit5.model.Product;
import com.anupama.junit5.service.ProductService;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/home")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products", produces = "application/json")
    public ResponseEntity<String> getProducts() throws JSONException {
        List<Product> products = productService.getAllProducts();
        logger.info("Received Product: {}", products);
        return new ResponseEntity<>(new JSONObject().put("products",products).toString(), HttpStatus.OK);
    }

    @PostMapping(value = "products", produces = "application/json")
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        Product product_created = productService.addProduct(product);
        logger.info("Adding products: {} ", product_created);
        return new ResponseEntity<>(product_created, HttpStatus.CREATED);
    }

    @GetMapping(value = "products/{id}", produces = "application/json")
    public ResponseEntity<Object> getSpecificProduct(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        logger.info("Received Product: {}", product);
        return ResponseEntity.ok().header("lang", "en").body(product);
    }
}