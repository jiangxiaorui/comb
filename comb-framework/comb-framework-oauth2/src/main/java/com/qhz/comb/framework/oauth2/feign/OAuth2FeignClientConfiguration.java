package com.qhz.comb.framework.oauth2.feign;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;


/**
 * FeignClient OAuth2.0配置
 *
 * @author jiangting
 * @since 1.0, 2018/5/4
 */
public class OAuth2FeignClientConfiguration {

    @Autowired
    private ClientCredentialsResourceDetails clientCredentialsResourceDetails;

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor(){
        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), clientCredentialsResourceDetails);
    }

    @Bean
    public OAuth2RestTemplate clientCredentialsRestTemplate() {
        return new OAuth2RestTemplate(clientCredentialsResourceDetails);
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        //设置日志
        return feign.Logger.Level.FULL;
    }
}
