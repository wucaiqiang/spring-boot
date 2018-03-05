package com.wu.boot.aop;

import com.wu.boot.annotation.MyAnStudent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
public class LogPrintAspect {

    @Pointcut("@annotation(com.wu.boot.annotation.CombinationAnn)")
    public void annotataionPointCut() {
    }

    @Pointcut("execution(public * com.wu.boot.service..*.*(..))")
    public void normalPointCut() {
    }

    @Before("normalPointCut()")
    public void doNormalBefore(JoinPoint joinPoint) throws Exception {
        MethodSignature signature=(MethodSignature)joinPoint.getSignature();
        Method method=signature.getMethod();
        System.out.println("方法："+method.getName()+"，参数为："+joinPoint.getArgs());
    }

    @Before("annotataionPointCut()")
    public void doAnnotationBefore(JoinPoint joinPoint) throws Exception {
        MethodSignature signature=(MethodSignature)joinPoint.getSignature();
        Method method=signature.getMethod();
        Annotation[] annotations = method.getAnnotations();
        for(Annotation annotation : annotations){
            System.out.println(annotation);
        }
        if(method.isAnnotationPresent(MyAnStudent.class)){
            MyAnStudent myAnStudent=method.getAnnotation(MyAnStudent.class);
            if(myAnStudent !=null){
                System.out.println("方法："+method.getName()+"注解值为："+myAnStudent.name());
            }
        }

    }

}
