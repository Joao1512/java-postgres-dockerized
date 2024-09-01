package org.example;

import com.sun.tools.javac.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info(LocalDateTime.now().toString());
        SpringApplication.run(MainApplication.class, args);
    }
}