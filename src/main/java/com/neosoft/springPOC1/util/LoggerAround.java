package com.neosoft.springPOC1.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class LoggerAround {
    private final Logger LOGGER = LoggerFactory.getLogger(LoggerAround.class);

    @Pointcut(value = "execution(* com.neosoft.springPOC1.*.*.*(..))")
    public void cuttingPoint(){

    }

    @Around(value = "cuttingPoint()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        Object[] passParameter = joinPoint.getArgs();
        LOGGER.info("Method Input Data : "+mapper.writeValueAsString(passParameter));
        Object outputOfMethod = joinPoint.proceed();
        LOGGER.info("Method Produce Data :"+mapper.writeValueAsString(outputOfMethod));
        return outputOfMethod;
    }
}
