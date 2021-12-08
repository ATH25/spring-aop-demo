package com.in28minutes.spring.aop.springaop;

import org.springframework.stereotype.Repository;

@Repository // a class that talks to the DB should have @Repository annotation.
public class Dao1 {

	public String retrieveSomething(){
		return "Dao1";
	}

}
