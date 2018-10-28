package com.weibo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

//引入aop
@Aspect
@Component //引入到spring容器
public class HttpAspect {

    //spring自带的日志框架
    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //拦截方法，参数中两个点表示不管任何参数都会被拦截。如果要拦截类的所有方法，该用*
    //@Before("execution(public * com.weibo.controller.HelloController.say(..))")
    @Before("execution(public * com.weibo.controller.HelloController.*(..))")
    public void before(){
        System.out.println(11111);
    }

    //注解内容与上面方法一样，可以修改为下一个方法的样子
    @After("execution(public * com.weibo.controller.HelloController.*(..))")
    public void after(){
        System.out.println(2222);
    }

    @Pointcut("execution(public * com.weibo.controller.GirlController.*(..))")
    public void log2(){
        System.out.println(11111);
    }

    @Before("log2()")
    public void doBefore(JoinPoint joinPoint){ //获取请求信息
        logger.info("before");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //获取请求的url
        logger.info("url={}", request.getRequestURL());

        //获取请求的method
        logger.info("method={}", request.getMethod());

        //获取请求的ip
        logger.info("ip={}", request.getRemoteAddr());

        //获取请求的类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //获取请求的参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log2()")
    public void doAfter(){
        logger.info("after");
    }

    @AfterReturning(returning = "object", pointcut = "log2()")
    public void doAfterReturning(Object object){
        logger.info("response={}", object.toString()); //打印请求的返回值
    }
}
