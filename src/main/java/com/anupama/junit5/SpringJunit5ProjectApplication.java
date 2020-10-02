package com.anupama.junit5;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "JUnit5 Unit Testing", version = "1.0.0", description = "Practice Project to learn JUnit5 Unit Testing with different frameworks"))
public class SpringJunit5ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJunit5ProjectApplication.class, args);
    }

}