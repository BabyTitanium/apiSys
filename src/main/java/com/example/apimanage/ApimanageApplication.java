package com.example.apimanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@SpringBootApplication

@ComponentScan("com.example.apimanage.*")
public class ApimanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApimanageApplication.class, args);
    }

}
