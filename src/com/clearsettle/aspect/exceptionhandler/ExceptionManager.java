package com.clearsettle.aspect.exceptionhandler;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionManager {

	@Pointcut(" execution(* com.clearsettle.controller.impl..*(..))")
    public void handleExcepiton() {}

    
}