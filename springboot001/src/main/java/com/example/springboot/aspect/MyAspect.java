package com.example.springboot.aspect;

import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect {

	// 切面
	@Before("execution(* com.example.springboot.service.impl.UserServiceImpl.printUser(..))")
	public void before(){
		System.out.println("before....");
	}

	@After("execution(* com.example.springboot.service.impl.UserServiceImpl.printUser(..))")
	public void after(){
		System.out.println("after....");
	}

	// 切点
	@Pointcut("execution(* com.example.springboot.service.impl.UserServiceImpl.printUser(..))")
	public void pointCutMehotd(){
	}

	@AfterReturning("pointCutMehotd()")
	public void afterReturning(){
		System.out.println("afterReturning....");
	}

}
