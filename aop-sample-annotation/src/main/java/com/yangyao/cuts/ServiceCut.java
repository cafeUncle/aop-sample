package com.yangyao.cuts;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 进入目标方法时,先织入Around,再织入Before，退出目标方法时，先织入Around,再织入AfterReturning,最后才织入After。
 * 注意:Spring AOP的环绕通知会影响到AfterThrowing通知的运行,不要同时使用!同时使用也没啥意义。
 *
 *  A:@Pointcut("execution(* com.aijava.springcode.service..*.*(..))")
 *  第一个*表示匹配任意的方法返回值，..(两个点)表示零个或多个，上面的第一个..表示service包及其子包,第二个*表示所有类,第三个*表示所有方法，第二个..表示
 *  方法的任意参数个数
 *  B:@Pointcut("within(com.aijava.springcode.service.*)")
 *  within限定匹配方法的连接点,上面的就是表示匹配service包下的任意连接点
 *  C:@Pointcut("this(com.aijava.springcode.service.UserService)")
 *  this用来限定AOP代理必须是指定类型的实例，如上，指定了一个特定的实例，就是UserService
 *  D:@Pointcut("bean(userService)")
 *  bean也是非常常用的,bean可以指定IOC容器中的bean的名称
 *
 *  https://www.cnblogs.com/liuruowang/p/5711563.html
 *  https://www.cnblogs.com/hongwz/p/5764917.html
 */
//@Component
//@Aspect
public class ServiceCut {

    @Pointcut("execution(* com.yangyao.services..*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("services AOP before Advice start");
        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.toString(args));
        System.out.println("services AOP before Advice end");
    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("services AOP After Advice...start");
        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.toString(args));
        System.out.println("services AOP After Advice...end");
    }

    @AfterReturning(pointcut = "pointCut()", returning = "returnVal")
    public void afterReturn(JoinPoint joinPoint, Object returnVal) {
        System.out.println("services AOP AfterReturning Advice start");
        System.out.println("services AOP AfterReturning && returnVal = " + returnVal);
        System.out.println("services AOP AfterReturning Advice end");
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("services AOP AfterThrowing Advice start ..." + error);
        System.out.println("services AOP AfterThrowing end ...");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("services AOP Around start...");
        Object o = null;
        try {
            o = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("services AOP Around end...");
        return o;
    }
}
