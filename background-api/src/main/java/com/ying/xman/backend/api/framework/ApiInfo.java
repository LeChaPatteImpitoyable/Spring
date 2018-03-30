package com.ying.xman.backend.api.framework;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Created by yingsy on 2018/3/27.
 */
@Target(ElementType.TYPE)
//生命周期
@Retention(RetentionPolicy.RUNTIME)
@Inherited
//通过component-scan能扫描到 可以继承
@Component
public @interface ApiInfo {

    String name();

    String version();
}
