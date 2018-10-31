package com.pinyougou.manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Administrator on 2018/10/31.
 * swagger api管理工具
 */
@Component
@EnableWebMvc
@EnableSwagger2   //开启swagger2
public class Swagger2Config  {

    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("aa")  //进行分组,中文出现错误
                .apiInfo(buildApiInf())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pinyougou.manager"))//controller路径
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * apiInfo是接口文档的基本说明信息
     * @return
     */
    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder()
                .title("品优购系统-manager-web的接口文档")  //标题
                .description("提供了管理员后台管理的接口文档") //描述
                .termsOfServiceUrl("https://github.com/gengzi/pinyougouparent")  //服务网址
                .version("1.4")
                .contact("gengzi")
                .build();
    }





}
