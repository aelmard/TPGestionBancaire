package com.tpIntergiciel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by abdel on 18/12/2016.
 */
@SpringBootApplication
@ComponentScan({"com.tpIntergiciel"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}