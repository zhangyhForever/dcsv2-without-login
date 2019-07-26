package com.zicms.configuration.beetl;

import org.beetl.core.Function;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * @ Author       : forever
 * @ Date         : Created in 2019/7/25
 * @ Description  : beetl配置类，用于加载beetl配置文件及视图解析器
 */
@Configuration
public class BeetlConfiguration {

    @Bean(name = "beetlConf")
    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration(
            @Qualifier("functionPackages") Map<String, Object> functionPackages,
            @Qualifier("function") Map<String, Function> function) {
        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();

        //添加自定义函数
        beetlGroupUtilConfiguration.setFunctions(function);
        beetlGroupUtilConfiguration.setFunctionPackages(functionPackages);

        //获取Spring Boot 的ClassLoader
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if (loader == null) {
            loader = BeetlConfiguration.class.getClassLoader();
        }

        //加载自己的配置文件
        InputStream in = loader.getResourceAsStream("config/beetl.properties");
        Properties extProperties = new Properties();
        try {
            extProperties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        beetlGroupUtilConfiguration.setConfigProperties(extProperties);//额外的配置，可以覆盖默认配置，一般不需要
        ClasspathResourceLoader cploder = new ClasspathResourceLoader(loader);

        beetlGroupUtilConfiguration.setResourceLoader(cploder);
        beetlGroupUtilConfiguration.init();
        //如果使用了优化编译器，涉及到字节码操作，需要添加ClassLoader
        beetlGroupUtilConfiguration.getGroupTemplate().setClassLoader(loader);
        return beetlGroupUtilConfiguration;

    }

    @Bean(name = "beetlViewResolver")
    public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConf") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setSuffix(".html");
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
        return beetlSpringViewResolver;
    }

    @Bean(name = "groupTemplate")
    public GroupTemplate getGroupTemplate(
            @Qualifier("beetlConf") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        return beetlGroupUtilConfiguration.getGroupTemplate();
    }
}