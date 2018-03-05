package com.wu.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseFunService {
    @Autowired
    private FunService funService;

    public String sayHello(String word){
        return funService.sayHello(word);
    }
}
