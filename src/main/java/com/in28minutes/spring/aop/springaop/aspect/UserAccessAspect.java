package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class UserAccessAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//What kind of method calls I would intercept
	//execution(* PACKAGE.*.*(..))
	
	
	@Before("execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))")//in the package specified, any class, any method with any kind/number of arguments. 
	public void before(JoinPoint joinPoint){
		logger.info(" Check for user access ");
		logger.info(" Allowed execution for {}", joinPoint);
	}
	
}