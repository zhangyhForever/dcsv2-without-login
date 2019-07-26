package com.zicms.configuration.beetl;

import org.beetl.core.Function;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * @ Author       : forever
 * @ Date         : Created in 2019/7/26
 * @ Description  : beetl标签管理类，用来加载自定义标签
 */
@Component
public class BeetlTagFactoryManager implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean(name = "function")
    public Map<String, Function> function(){
        return applicationContext.getBeansOfType(Function.class);
    }

    @Bean(name = "functionPackages")
    public Map<String, Object> functionPackages(){
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(BeetlFunction.class);
        for(Map.Entry<String, Object> entry: beans.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        return beans;
    }
}
