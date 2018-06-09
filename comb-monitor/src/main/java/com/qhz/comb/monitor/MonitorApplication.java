package com.qhz.comb.monitor;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * 监控中心
 *
 * @author jiangting
 * @since 1.0, 2018/4/18
 */
@EnableAdminServer
@EnableTurbineStream
@SpringBootApplication
@EnableDiscoveryClient
public class MonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitorApplication.class, args);
    }
}
