package com.qhz.comb.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 * 服务追踪
 *
 * @author jiangting
 * @since 1.0, 2018/4/23
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZipkinStreamServer
public class ZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class, args);
    }
}
