package com.wu.boot.listener;

import com.wu.boot.event.MessageEvent;
import com.wu.boot.service.FunService;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener implements ApplicationListener<MessageEvent> {
    @Override
    public void onApplicationEvent(MessageEvent event) {
        Object object=event.getSource();
        if(object instanceof FunService){
            FunService funService=(FunService)object;
            System.out.println("监听器获取对象值："+funService.getBookName());
        }
        System.out.println("收到消息："+event.getMessage());
    }
}
