package com.anupama.junit5;

import com.anupama.junit5.model.Product;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SpringJunit5ProjectApplicationTests {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost:8081/home";
        RestAssured.port = 8081 ;
    }

    @Test
    public void testGetProductAPI(){
        RestAssured.
                given().
                when().
                    get("http://localhost:8081/home/products").
                then().
                    assertThat().statusCode(200).
                and().
                    contentType(ContentType.JSON);
//                and().body("RestResponse.result.name", is("\"{\"products\":[{\"name\":\"Pen\",\"id\":1},{\"name\":\"Pencil\",\"id\":2},{\"name\":\"Eraser\",\"id\":3}]}\""));


    }
}

/*@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringJunit5ProjectApplicationTests.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringJunit5ProjectApplicationTests {

    @LocalServerPort
    private int port;

    @MockBean
    TestRestTemplate mockRestTemplate;

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testRetrieveStudentCourse() {

        HttpEntity<Product> entity = new HttpEntity<Product>(null, headers);

        ResponseEntity<Product> response = mockRestTemplate.exchange(
                createURLWithPort("/home/products"),
                HttpMethod.GET, entity, Product.class);

//        Product expected = "{id:Course1,name:Spring,description:10Steps}";

        JSONAssert.assertEquals("", response.getBody().toString(), false);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}*/

