package com.clearsettle.aspect.exceptionhandler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.clearsettle.exception.BussinesException;
import com.clearsettle.util.*;

/**
 * 
 * @author taner cakiroglu
 *
 */


@Aspect
public class ExceptionInterceptor {

	/**
	 * 
	 * @param joinPoint
	 * @param bean
	 * @param handleExcpetion
	 * @return Object
	 * @comment catch and determine what to do when controller throw excpetion
	 * @throws Throwable
	 */
	@Around(value = "com.clearsettle.aspect.exceptionhandler.ExceptionManager.handleExcepiton()" + "&& target(bean) "
			+ "&& @annotation(com.clearsettle.aspect.exceptionhandler.HandleException)"
			+ "&& @annotation(handleExcpetion)", argNames = "bean,handleExcpetion")
	public Object handleExcpetion(ProceedingJoinPoint joinPoint, Object bean, HandleException handleExcpetion)
			throws Throwable {

		Object ret = null;
		try {
			ret = joinPoint.proceed();
			return ret;
		} catch (BussinesException bex) {
			return Util.constructJSON(Constants.BUSSINES_EXCEPTION, bex.getMessage());
		} catch (Exception ex) {
			ex.printStackTrace();
			return Util.constructJSON(Constants.EXCEPTION, ex.getStackTrace());
		}

	}

}
