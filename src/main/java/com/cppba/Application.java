package com.cppba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.net.UnknownHostException;

// same as @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication(scanBasePackages = "com.cppba")
@ServletComponentScan
public class Application {
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication.run(Application.class, args);
    }
}
