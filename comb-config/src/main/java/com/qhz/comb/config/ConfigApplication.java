package com.qhz.comb.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author jiangting
 * @since 1.0, 2018/4/20
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApplication {

    public static void main(String[] args){
        SpringApplication.run(ConfigApplication.class,args);
    }
}
