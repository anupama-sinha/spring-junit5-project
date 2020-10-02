package com.anupama.junit5.controller;

import com.anupama.junit5.model.Product;
import com.anupama.junit5.service.ProductService;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ProductController.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService mockProductService;

    @Test
//    @RepeatedTest((2))
    @DisplayName("TestGetProduct")
    @Ignore
    void getProducts() throws Exception {
        //given
        RequestBuilder request = MockMvcRequestBuilders.get("/home/products");
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(Long.valueOf(1), "Pen"));
        products.add(new Product(Long.valueOf(2), "Pencil"));
        //when
        Mockito.when(mockProductService.getAllProducts()).thenReturn(products);
        MvcResult result = mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"products\":[{\"name\":\"Pen\",\"id\":1},{\"name\":\"Pencil\",\"id\":2}]}")).andReturn();
        //then
        assertEquals("{\"products\":[{\"name\":\"Pen\",\"id\":1},{\"name\":\"Pencil\",\"id\":2}]}",result.getResponse().getContentAsString());
        assertEquals(200,result.getResponse().getStatus(),"Check Get Product Status");
        JSONAssert.assertEquals("{\"products\":[{\"name\":\"Pen\",\"id\":1},{\"name\":\"Pencil\",\"id\":2}]}",result.getResponse().getContentAsString(),false); //Strict arg
        //Check all assertion methods

        String response = "{\n" +
                "    \"products\" : [{" +
                "        \"id\" : 1," +
                "        \"name\" : \"Pen\"" +
                "    },{\n" +
                "        \"id\" : 2,\n" +
                "        \"name\" : \"Pencil\"" +
                "    }]\n" +
                "}";
        DocumentContext context = JsonPath.parse(response);
        int length = context.read("$.length()");
        assertEquals(1,length);
        List<String> names = context.read("$..name");
        assertThat(names).containsExactly("Pen","Pencil");
        System.out.println(context.read("$..[1]").toString());
        System.out.println(context.read("$..[0:2]").toString());
        System.out.println(context.read("$..{[?(@.name)]}").toString());
        System.out.println(context.read("$..{[?(@.name=='Pen')]}").toString());
        System.out.println(context.read("$..{[?(@.id=='1')]}").toString());

//        System.out.println(context.read("$..[?(@.name)]").toString());

//        JSONAssert.assertEquals("[1,2]", context.read("$..{[?(@.id)]}").toString(), false);

        //Check if methods called or not
        Mockito.verify(mockProductService).getAllProducts();
        Mockito.verify(mockProductService,Mockito.times(1)).getAllProducts();
    }

    @Test
    @DisplayName("Test Exceptions")
    @Disabled
    void testExceptions() throws Exception {
        //given
        RequestBuilder request = MockMvcRequestBuilders.get("/products");
        //when
        Mockito.when(mockProductService.getAllProducts()).thenThrow(new RuntimeException("Error in fetching the data"));
        mockProductService.getAllProducts();
        //then


    }
}