package com.clearsettle.aspect.exceptionhandler;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 
 * @author taner cakiroglu
 *
 */

@Aspect
@Component
public class ExceptionManager {

	/**
	 * @comment determeine package to cut
	 */
	@Pointcut(" execution(* com.clearsettle.controller.impl..*(..))")
	public void handleExcepiton() {
	}

}