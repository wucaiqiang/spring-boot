package com.wu.boot.configuration;

import com.wu.boot.annotation.EnableCaching;
import com.wu.boot.annotation.EnableMyAutoRegistrar;
import com.wu.boot.bean.User;
import com.wu.boot.condition.LinuxCondition;
import com.wu.boot.condition.WindowCondition;
import com.wu.boot.service.LinuxListService;
import com.wu.boot.service.ListService;
import com.wu.boot.service.WindowListService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 *
 */
@Configuration
@ComponentScan(value = "com.wu.boot")
@EnableAspectJAutoProxy
//@EnableCaching(autoRegister = false)
//@Import(CommonsClientAutoConfiguration.class)
//@EnableMyAutoRegistrar
@PropertySource(value = "classpath:application.properties", encoding = "utf-8")
public class Diconfig {
    @Value("${book.name}")
    private String name;

    @Bean
    @Conditional(WindowCondition.class)
    public ListService windowListService() {
        return new WindowListService();
    }
    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxListService() {
        return new LinuxListService();
    }
}
