package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class AfterAopAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@AfterReturning(value = "execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))", returning = "result" ) //The AfterReturning advice runs after a successful completion of a target method.
	public void afterReturning(JoinPoint joinPoint, Object result){
		logger.info("{} returned with value {}", joinPoint, result);
	}
	
	@AfterThrowing(value = "execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))", throwing = "exception" ) 
	public void afterThrowing(JoinPoint joinPoint, Exception exception){
		logger.info("{} throw exception {}", joinPoint, exception);
	}
	
	@After(value = "execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))" ) 
	public void after(JoinPoint joinPoint){
		logger.info("After the execution of {}", joinPoint);
	}
	
	//git test. 
}