package com.anupama.junit5.repository;

import com.anupama.junit5.model.Product;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
class ProductRepositoryTest{
    @MockBean
    private ProductRepository mockProductRepository;

    @Test
    @DisplayName("TestGetProduct")
//    @Disabled
    void testGetProduct(){
        //given
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(Long.valueOf(1), "Pen"));
        products.add(new Product(Long.valueOf(2), "Pencil"));

        //when
        when(mockProductRepository.findAll()).thenReturn(products);
        List<Product> resultProducts = mockProductRepository.findAll();

        //then
        assertEquals(2,resultProducts.size(),"Check Count of Products");
        verify(mockProductRepository).findAll();
    }
}
