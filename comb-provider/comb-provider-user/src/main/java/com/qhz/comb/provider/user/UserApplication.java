package com.qhz.comb.provider.user;

import com.qhz.comb.framework.oauth2.feign.EnableOAuth2FeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 用户中心
 *
 * @author jiangting
 * @since 1.0, 2018/4/25
 */
@SpringCloudApplication
@EnableOAuth2Client
@EnableOAuth2FeignClient
@EnableFeignClients("com.qhz.comb.provider")
@EnableTransactionManagement
@ComponentScan("com.qhz.comb")
@EnableScheduling
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
