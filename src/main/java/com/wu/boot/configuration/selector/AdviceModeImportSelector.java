package com.wu.boot.configuration.selector;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.GenericTypeResolver;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class AdviceModeImportSelector<A extends Annotation> implements ImportSelector, BeanClassLoaderAware, EnvironmentAware {
    private ClassLoader beanClassLoader;
    private Environment environment;
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Class<?> annoType = GenericTypeResolver.resolveTypeArgument(getClass(), AdviceModeImportSelector.class);
        AnnotationAttributes annotationAttributes=AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(annoType.getName(), false));

        List<String> factories = new ArrayList<>(new LinkedHashSet<>(SpringFactoriesLoader
                .loadFactoryNames(annoType, this.beanClassLoader)));

        boolean autoRegister = annotationAttributes.getBoolean("autoRegister");

        System.out.println("----------------------"+autoRegister);
        return factories.toArray(new String[factories.size()]);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.beanClassLoader = classLoader;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
