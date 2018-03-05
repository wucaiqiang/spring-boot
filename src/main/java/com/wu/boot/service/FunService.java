package com.wu.boot.service;

import com.wu.boot.annotation.CombinationAnn;
import com.wu.boot.annotation.MyAnStudent;
import com.wu.boot.event.MessageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class FunService {
    @Value("${book.name}")
    private String bookName;
    @Value("${book.author}")
    private String bookAuthor;
    @Autowired
    private Environment environment;
    @Autowired
    private ApplicationContext applicationContext;

    public String sayHello(String word) {
        return "hello " + word;
    }

    public void pushMessage(String message) {
        applicationContext.publishEvent(new MessageEvent(this, message));
    }

    @CombinationAnn(name = "my_value")
    public String sayAnnotation(String word) {
        return "hello " + word;
    }

    public String sayEnvironment(String key) {
        return environment.getProperty(key);
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
}
