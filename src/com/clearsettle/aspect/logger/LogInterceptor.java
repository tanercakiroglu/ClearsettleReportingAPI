package com.clearsettle.aspect.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

/**
 * 
 * @author taner �ak�ro�lu
 *
 */

@Aspect
public class LogInterceptor {

	 private final static Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

	 /**
	  * @comment before controller method try to logg
	  * @param jp
	  * @param bean
	  * @param logme
	  */
	@Before(value = "com.clearsettle.aspect.logger.LogManager.auditLog()" + "&& target(bean) "
			+ "&& @annotation(com.clearsettle.aspect.logger.Loggable)" + "&& @annotation(logme)", argNames = "bean,logme")
	public void auditLog(JoinPoint jp, Object bean, Loggable logme) {

		logger.debug(String.format("Log Message: %s", logme.message()));
		logger.debug(String.format("Bean Called: %s", bean.getClass().getName()));
		logger.debug(String.format("Method Called: %s", jp.getSignature().getName()));

	}
   /**
    * 
    * @param joinPoint
    * @param bean
    * @param logme
    * @return object
    * @comment calculate method performance
    * @throws Throwable
    */
	@Around(value = "com.clearsettle.aspect.logger.LogManager.performanceLog()" + "&& target(bean) "
			+ "&& @annotation(com.clearsettle.aspect.logger.Loggable)" + "&& @annotation(logme)", argNames = "bean,logme")
	public Object performanceLog(ProceedingJoinPoint joinPoint, Object bean,Loggable logme) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		Object ret = joinPoint.proceed();

		stopWatch.stop();

		StringBuffer logMessage = new StringBuffer();
		logMessage.append(joinPoint.getTarget().getClass().getName());
		logMessage.append(".");
		logMessage.append(joinPoint.getSignature().getName());
		logMessage.append("(");
		// append args
		Object[] args = joinPoint.getArgs();
		for (int i = 0; i < args.length; i++) {
			logMessage.append(args[i]).append(",");
		}
		if (args.length > 0) {
			logMessage.deleteCharAt(logMessage.length() - 1);
		}

		logMessage.append(")");
		logMessage.append(" execution time: ");
		logMessage.append(stopWatch.getTotalTimeMillis());
		logMessage.append(" ms");
		logger.debug(logMessage.toString());

		return ret;
	}

}
