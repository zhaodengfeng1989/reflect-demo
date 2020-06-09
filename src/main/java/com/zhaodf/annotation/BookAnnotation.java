package com.zhaodf.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类：BookAnnotation
 *
 * @author zhaodf
 * @date 2020/6/9
 */
@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BookAnnotation {
    String value() default "";
}
