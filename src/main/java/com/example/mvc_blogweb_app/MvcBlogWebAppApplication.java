package com.example.mvc_blogweb_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MvcBlogWebAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(MvcBlogWebAppApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(){

        return "Hello Oscar From Tomcat server";
    }

}
