package com.yangyao.cuts;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 进入目标方法时,先织入Around,再织入Before，退出目标方法时，先织入Around,再织入AfterReturning,最后才织入After。
 * 注意:Spring AOP的环绕通知会影响到AfterThrowing通知的运行,不要同时使用!同时使用也没啥意义。
 */
@Component
@Aspect
public class ControllerCut {

    @Pointcut("execution(* com.yangyao.controllers..*.*(..))")
    public void pointCut() {
    }

    @AfterReturning(pointcut = "pointCut()", returning = "returnVal")
    public void afterReturn(JoinPoint joinPoint, Object returnVal) {
        System.out.println("controllers AOP AfterReturning Advice start");
        System.out.println("controllers AOP AfterReturning && returnVal = " + returnVal);
        System.out.println("controllers AOP AfterReturning Advice end");
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("controllers AOP AfterThrowing Advice start ..." + error);
        System.out.println("controllers AOP AfterThrowing end...");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("controllers AOP Around start...");
        Object o = null;
        try {
            o = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            o = "Exception!";
        }
        System.out.println("controllers AOP Around end...");
        return o;
    }
}
