package com.qhz.comb.framework.core.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器忽略属性配置
 *
 * @author jiangting
 * @since 1.0, 2018/5/30
 */
@Data
@Configuration
@RefreshScope
@ConditionalOnExpression("!'${ignore}'.isEmpty()")
@ConfigurationProperties(prefix = "ignore")
public class FilterIgnorePropertiesConfig {

    /**
     * url集合
     */
    private List<String> urls = new ArrayList<>();

    /**
     * 客户端集合
     */
    private List<String> clients = new ArrayList<>();
}
