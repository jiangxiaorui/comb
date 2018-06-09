package com.qhz.comb.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 授权中心
 *
 * @author jiangting
 * @since 1.0, 2018/4/24
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.qhz.comb.provider")
@ComponentScan("com.qhz.comb")
@EnableCaching
public class AuthApplication {

    public static void main(String[] args){
        SpringApplication.run(AuthApplication.class,args);
    }
}
