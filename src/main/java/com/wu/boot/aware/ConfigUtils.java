package com.wu.boot.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.annotation.PostConstruct;
import java.io.InputStreamReader;
import java.util.Properties;

@Component
public class ConfigUtils implements ResourceLoaderAware, ApplicationContextAware {
    private ResourceLoader resourceLoader;
    private ApplicationContext applicationContext;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("ConfigUtils 加载文件》》》》");
        Resource resource = resourceLoader.getResource("classpath:config/code/code.properties");
        Properties properties = new Properties();
        properties.load(new InputStreamReader(resource.getInputStream(), "UTF-8"));
        Environment environment=applicationContext.getEnvironment();
        Set<Entry<Object, Object>> set = properties.entrySet();
        for (Entry<Object, Object> entry : set) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            System.out.println(key+":"+value);
        }
        String prott = environment.getProperty("book.author");
        System.out.println("!!!!!!!!!!!!!!" + prott);
       /* if(applicationContext instanceof AnnotationConfigApplicationContext){
            AnnotationConfigApplicationContext context=(AnnotationConfigApplicationContext)applicationContext;
            System.out.println("上下文类为：AnnotationConfigApplicationContext");
        }*/
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
