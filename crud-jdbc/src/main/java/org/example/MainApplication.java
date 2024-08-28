package org.example;

import com.sun.tools.javac.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        SpringApplication.run(MainApplication.class, args);
    }
}