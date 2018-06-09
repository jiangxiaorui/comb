package com.qhz.comb.provider.bus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;


/**
 * 资源服务配置
 *
 * @author jiangting
 * @since 1.0, 2018/5/25
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and()
                .csrf().disable()
                .authorizeRequests().antMatchers("/v2/api-docs").permitAll()
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());

    }
}
