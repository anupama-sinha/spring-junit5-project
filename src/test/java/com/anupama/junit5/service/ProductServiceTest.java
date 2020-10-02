package com.anupama.junit5.service;

import com.anupama.junit5.model.Product;
import com.anupama.junit5.repository.ProductRepository;
import com.anupama.junit5.service.serviceimpl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class ProductServiceTest{
    @InjectMocks
    private ProductServiceImpl mockProductService;

    @Mock
    private ProductRepository mockProductRepository;

    @Test
    @DisplayName("TestGetProduct")
    void testGetProduct(){
        //given
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(Long.valueOf(1), "Pen"));
        products.add(new Product(Long.valueOf(2), "Pencil"));

        //when
        when(mockProductRepository.findAll()).thenReturn(products);
        List<Product> resultProducts = mockProductService.getAllProducts();

        //then
        assertEquals(2,resultProducts.size(),"Check Count of Products");
        verify(mockProductRepository).findAll();
    }
}
