package com.qhz.comb.devtools.generator;

import com.qhz.comb.devtools.generator.properties.DevtoolsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 代码生成器
 *
 * @author jiangting
 * @since 1.0, 2018/4/25
 */
@SpringBootApplication
@EnableConfigurationProperties(DevtoolsProperties.class)
@EnableAutoConfiguration
public class GeneratorApplication {

    public static void main(String[] args){
        SpringApplication.run(GeneratorApplication.class,args);
    }
}
