package com.tetel.restful.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@ConfigurationProperties(prefix = "swagger2")
public class Swagger2Conf {

    protected String basePackage;
    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))//对哪个包进行扫描
                .build();

    }

    /**
     * 哪此内容在生成API
     * @return
     */
    private ApiInfo getApiInfo() {
        return  new ApiInfoBuilder()
                .title("UserService interface desc")
                .version("v1.0")
                .contact("tetel")
                .build();
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }
}
