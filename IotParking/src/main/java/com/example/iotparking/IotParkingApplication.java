package com.example.iotparking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class IotParkingApplication {

    public static void main(String[] args) {
        SpringApplication.run(IotParkingApplication.class, args);
    }

}
