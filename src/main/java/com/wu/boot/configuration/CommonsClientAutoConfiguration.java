package com.wu.boot.configuration;

import com.wu.boot.bean.User;
import com.wu.boot.condition.LinuxCondition;
import com.wu.boot.condition.WindowCondition;
import com.wu.boot.service.LinuxListService;
import com.wu.boot.service.ListService;
import com.wu.boot.service.WindowListService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Configuration
public class CommonsClientAutoConfiguration {
    @Bean(initMethod = "init", destroyMethod = "destory")
    @Profile(value = "dev")
    public User user() {
        System.out.println("CommonsClientAutoConfiguration 初始化User对象。。。");
        return new User("张三", 10);
    }
}
