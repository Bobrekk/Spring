package com.beginner.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Before("execution(* com.beginner.aop.service.*.*(..))")
    public void mesajVerMetodundanOnce(JoinPoint joinPoint) {
        System.out.println("Mesaj ver metodundan önce parametre yakalandı" +
                joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

    @After("execution(* com.beginner.aop.service.*.*(..))")
    public void mesajVerMetodundanSonra(JoinPoint joinPoint) {
        System.out.println("Mesaj ver metodundan sonra parametre yakalandı" +
                joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }
}
