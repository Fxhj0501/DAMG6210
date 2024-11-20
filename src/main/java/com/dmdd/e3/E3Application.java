package com.dmdd.e3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.dmdd.*")
@MapperScan("com.dmdd.mapper")
public class E3Application {

    public static void main(String[] args) {
        SpringApplication.run(E3Application.class, args);
    }

}
