package com.qhz.comb.provider.bus;

import com.qhz.comb.framework.oauth2.feign.EnableOAuth2FeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * 业务中心
 *
 * @author jiangting
 * @since 1.0, 2018/4/27
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableOAuth2Client
@EnableOAuth2FeignClient
@ComponentScan("com.qhz.comb")
public class BusApplication {

    public static void main(String[] args){
        SpringApplication.run(BusApplication.class,args);
    }
}
