package com.matias.agnolin.portfolio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PortfolioApplication {

    @Autowired
    private BCryptPasswordEncoder encoder;

    Logger LOGGER = LoggerFactory.getLogger(PortfolioApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
    }


    }
