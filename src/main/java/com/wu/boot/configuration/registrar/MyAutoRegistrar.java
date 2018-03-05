package com.wu.boot.configuration.registrar;

import com.wu.boot.configuration.CommonsClientAutoConfiguration;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.Ordered;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoRegistrar implements ImportBeanDefinitionRegistrar {
    public static final String AUTO_PROXY_CREATOR_BEAN_NAME =
            "com.wu.boot.config.internalAutoProxyCreator";
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        if (registry.containsBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME)) {
            BeanDefinition apcDefinition = registry.getBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME);
            if (!CommonsClientAutoConfiguration.class.getName().equals(apcDefinition.getBeanClassName())) {
                    apcDefinition.setBeanClassName(CommonsClientAutoConfiguration.class.getName());
            }
        }
        RootBeanDefinition beanDefinition = new RootBeanDefinition(CommonsClientAutoConfiguration.class);
//        beanDefinition.setSource(null);
//        beanDefinition.getPropertyValues().add("order", Ordered.HIGHEST_PRECEDENCE);
        registry.registerBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME, beanDefinition);
    }
}
