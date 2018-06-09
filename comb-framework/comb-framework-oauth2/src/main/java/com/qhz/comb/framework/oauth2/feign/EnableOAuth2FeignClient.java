package com.qhz.comb.framework.oauth2.feign;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 启用FeignClient OAuth2.0验证
 *
 * @author jiangting
 * @since 1.0, 2018/5/4
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(OAuth2FeignClientConfiguration.class)
public @interface EnableOAuth2FeignClient {

}
