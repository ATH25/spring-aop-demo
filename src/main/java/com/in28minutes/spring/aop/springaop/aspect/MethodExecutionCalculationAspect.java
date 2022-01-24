package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect 
@Configuration
public class MethodExecutionCalculationAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Around("execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))") //around this package. You can do something before and after the execution of methods in this package
	public void around(ProceedingJoinPoint joinPoint) throws Throwable { //methos name can be anything. 
		long startTime = System.currentTimeMillis();

		joinPoint.proceed(); //proceed with target method invocation. 

		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("Time Taken by {} is {} milliseconds ", joinPoint, timeTaken);
	}
}
