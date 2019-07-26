package com.zicms.configuration.beetl;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ Author       : forever
 * @ Date         : Created in 2019/7/26
 * @ Description  : what to do ...
 */

@Component
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BeetlFunction {

    String value() default "";
}
