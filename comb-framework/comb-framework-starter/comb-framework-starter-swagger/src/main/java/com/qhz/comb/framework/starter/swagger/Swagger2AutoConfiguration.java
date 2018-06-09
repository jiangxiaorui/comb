package com.qhz.comb.framework.starter.swagger;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 通用配置
 *
 * @author jiangting
 * @since 1.0, 2018/5/23
 */
@Configuration
@EnableSwagger2
@Profile("!prod")
@ConditionalOnProperty(name = "comb.swagger2.enable", havingValue = "true")
@EnableConfigurationProperties({Swagger2Properties.class})
public class Swagger2AutoConfiguration {

    @Autowired
    private Swagger2Properties swagger2Properties;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .securitySchemes(Lists.newArrayList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage(swagger2Properties.getBasePackage()))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swagger2Properties.getTitle())
                .description(swagger2Properties.getDescription())
                .contact(new Contact("", "", ""))
                .version(swagger2Properties.getVersion())
                .build();
    }


    private ApiKey apiKey() {
        return new ApiKey(swagger2Properties.getApiName(), swagger2Properties.getApiKeyName(), ApiKeyVehicle.HEADER.getValue());
    }
}
