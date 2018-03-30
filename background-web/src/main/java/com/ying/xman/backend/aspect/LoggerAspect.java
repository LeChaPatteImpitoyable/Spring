package com.ying.xman.backend.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * make logger
 *
 */
@Aspect
//@Component
public class LoggerAspect {
    
    private static final Logger LOG = LoggerFactory.getLogger(LoggerAspect.class);
    private ThreadLocal<Long> startTime = new ThreadLocal<Long>();
    private ThreadLocal<JoinPoint> joinPoints = new ThreadLocal<JoinPoint>();

    @Pointcut("execution(public * com.ying.xman.backend.services.*.impl.*.*(..))")
    public void log1(){
        LOG.info(">>----------------- Service -----------------<<");
    }

    @Pointcut("execution(public * com.ying.xman.backend.api.action.*.*(..))")
    public void log2(){
        LOG.info(">>----------------- Action -----------------<<");
    }

    @Before("log1() || log2()")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        LOG.info(">>----------------- 开始请求>>>>请求对象:["+className+"] 请求方法：["+methodName+"()] -----------------<<");
        joinPoints.set(joinPoint);
        startTime.set(System.currentTimeMillis());
        Object[] args  = joinPoint.getArgs();
        LOG.info("【"+joinPoint.getSignature().getName()+"()】请求参数 --> "+ JSON.toJSONString(args));
    }

    @AfterReturning(returning = "o",pointcut = "log1() || log2()")
    public void afterReturning(Object o) {
        JoinPoint joinPoint = joinPoints.get();
        long end = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        LOG.info("【"+methodName+"()】响应结果 --> " + JSON.toJSONString(o));
        LOG.info("【"+methodName + "()】--> start: " + startTime.get() + ",  end: " + end  + ", cost time:--->" +  (end - startTime.get()));
        LOG.info(">>----------------- 请求结束>>>>请求对象:["+className+"] 请求方法：["+methodName+"()] -----------------<<");
    }

}
