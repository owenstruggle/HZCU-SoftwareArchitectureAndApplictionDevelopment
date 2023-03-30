package com.example.experiment05_4.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Owem
 * @date 2023/3/30 14:50
 * @description TODO
 **/
@Aspect // 使之成为切面类
@Component // 把切面类加入到IOC容器中
public class AopLog {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //线程局部的变量,解决多线程中相同变量的访问冲突问题。
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    //定义切点
    @Pointcut("execution(public * com.example.experiment05_4..*.*(..))")
    public void aopWebLog() {
    }

    @Before("aopWebLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = null;
        if (attributes != null) {
            request = attributes.getRequest();
        }

        // 记录下请求内容
        if (request != null) {
            logger.info("URL : " + request.getRequestURL().toString());
        }
        if (request != null) {
            logger.info("HTTP方法 : " + request.getMethod());
        }
        if (request != null) {
            logger.info("IP地址 : " + request.getRemoteAddr());
        }
        logger.info("类的方法 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //logger.info("参数 : " + Arrays.toString(joinPoint.getArgs()));
        if (request != null) {
            logger.info("参数 : " + request.getQueryString());
        }
    }

    @AfterReturning(pointcut = "aopWebLog()", returning = "retObject")
    public void doAfterReturning(Object retObject) {
        // 处理完请求，返回内容
        logger.info("应答值 : " + retObject);
        logger.info("费时: " + (System.currentTimeMillis() - startTime.get()));
    }

    //抛出异常后通知（After throwing advice） ： 在方法抛出异常退出时执行的通知。
    @AfterThrowing(pointcut = "aopWebLog()", throwing = "ex")
    public void addAfterThrowingLogger(Exception ex) {
        logger.error("执行 " + " 异常", ex);
    }
}
