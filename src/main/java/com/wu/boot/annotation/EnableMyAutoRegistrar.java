package com.wu.boot.annotation;


import com.wu.boot.configuration.registrar.MyAutoRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MyAutoRegistrar.class)
public @interface EnableMyAutoRegistrar {

}
