package com.infogain.ecommerce.discovery;

import org.springframework.boot.SpringApplication;

/**
 * Created by VRavuri on 01-11-2016.
 */

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaDiscoveryServiceApplication {

    public static void main(String[] args) {
    	SpringApplication.run(EurekaDiscoveryServiceApplication.class, args);
    }
}