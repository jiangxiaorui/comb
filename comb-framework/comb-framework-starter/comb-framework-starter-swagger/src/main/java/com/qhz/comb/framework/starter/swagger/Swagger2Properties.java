package com.qhz.comb.framework.starter.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Swagger2 属性
 *
 * @author jiangting
 * @since 1.0, 2018/5/23
 */
@Data
@ConfigurationProperties(prefix = "comb.swagger2")
public class Swagger2Properties {

    private String basePackage;
    private String title;
    private String description;
    private String version;
    private String apiName;
    private String apiKeyName;

}
