package com.qhz.comb.framework.base.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatisPlus配置
 *
 * @author jiangting
 * @since 1.0, 2018/4/26
 */
@Configuration
@MapperScan(basePackages = { "com.qhz.comb.**.mapper" })
public class MyBatisPlusConfiguration {

}
