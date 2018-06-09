package com.qhz.comb.auth.config;


import com.qhz.comb.auth.error.WebResponseExceptionTranslator;
import com.qhz.comb.auth.provider.DatabaseCachableClientDetailsService;
import com.qhz.comb.auth.provider.store.QhzJwtAccessTokenConverter;
import com.qhz.comb.framework.core.constant.GlobalConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 授权服务配置
 *
 * @author jiangting
 * @since 1.0, 2018/5/3
 */
@Order(Integer.MIN_VALUE)
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private WebResponseExceptionTranslator webResponseExceptionTranslator;

    @Autowired
    private DatabaseCachableClientDetailsService databaseCachableClientDetailsService;

    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(databaseCachableClientDetailsService);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //token增强配置
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(
                Arrays.asList(tokenEnhancer(), jwtAccessTokenConverter()));

        endpoints.tokenStore(redisTokenStore())
                .tokenEnhancer(tokenEnhancerChain)
                .authenticationManager(authenticationManager)
                .exceptionTranslator(webResponseExceptionTranslator)
                .reuseRefreshTokens(false)
                .userDetailsService(userDetailsService);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients()
                .tokenKeyAccess("isAuthenticated()")
                .checkTokenAccess("permitAll()");
    }

    @Bean
    public RedisTokenStore redisTokenStore() {
        RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
        tokenStore.setPrefix(GlobalConstant.ROOT_PREFIX);
        return tokenStore;
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        QhzJwtAccessTokenConverter jwtAccessTokenConverter = new QhzJwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(GlobalConstant.SIGN_KEY);
        return jwtAccessTokenConverter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * jwt 生成token 定制化处理
     *
     * @return TokenEnhancer
     */
    @Bean
    public TokenEnhancer tokenEnhancer() {
        return (accessToken, authentication) -> {
            final Map<String, Object> additionalInfo = new HashMap<>(1);
            additionalInfo.put("license", GlobalConstant.QHZ_LICENSE);
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
            return accessToken;
        };
    }
}
