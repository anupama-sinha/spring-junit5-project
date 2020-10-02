package com.anupama.junit5;

import com.anupama.junit5.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringJunit5ProjectApplicationTests {

    @MockBean
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        Product result = this.restTemplate.getForObject("http://localhost:8081/home/products", Product.class);

        assertNotEquals("Anupama",result);

        assertDoesNotThrow(()->{});
    }

}
