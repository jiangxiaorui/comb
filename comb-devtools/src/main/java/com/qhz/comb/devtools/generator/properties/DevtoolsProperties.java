package com.qhz.comb.devtools.generator.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 代码生成配置
 *
 * @author jiangting
 * @since 1.0, 2018/4/25
 */
@Data
@Component
@ConfigurationProperties(prefix = "comb.devtools")
public class DevtoolsProperties {

    /**
     * 项目路径
     */
    private String projectLocation;

    /**
     * 开发者
     */
    private String developer;

    /**
     * 表的前缀
     */
    private String tablePrefix;
}
