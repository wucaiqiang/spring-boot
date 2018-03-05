package com.wu.boot;

import com.wu.boot.configuration.Diconfig;
import com.wu.boot.service.FunService;
import com.wu.boot.service.ListService;
import com.wu.boot.service.UseFunService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(Diconfig.class);
        context.refresh();
//        UseFunService useFunService = context.getBean(UseFunService.class);
        FunService funService = context.getBean(FunService.class);
//        FunService funService2 = context.getBean(FunService.class);
//        System.out.println(useFunService.sayHello("吴才强"));
        System.out.println(funService.sayAnnotation("吴才强"));
////        System.out.println(funService == funService2);
//        System.out.println(funService.getBookName());
//        System.out.println(funService.getBookAuthor());
//        System.out.println(funService.sayEnvironment("book.author"));
//
//        funService.pushMessage("第一条消息");
//
//        System.out.println(funService.sayEnvironment("10001"));

        ListService listService = context.getBean(ListService.class);
        System.out.println(listService.listCmd());
        context.close();

    }
}
