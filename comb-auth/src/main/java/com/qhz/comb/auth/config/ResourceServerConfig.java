package com.qhz.comb.auth.config;

import com.qhz.comb.framework.core.config.FilterIgnorePropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

/**
 * @author jiangting
 * @since 1.0, 2018/5/21
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private FilterIgnorePropertiesConfig filterIgnorePropertiesConfig;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry =
                http.formLogin().loginPage("/authentication/require")
                        .loginProcessingUrl("/authentication/form")
                        .and()
                        .authorizeRequests();

        filterIgnorePropertiesConfig.getUrls().forEach(url -> registry.antMatchers(url).permitAll());

        registry.anyRequest().authenticated()
                .and()
                .csrf().disable()
                .authorizeRequests().antMatchers("/v2/api-docs").permitAll()
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}
