package com.clearsettle.aspect.logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 
 * @author taner çakýroðlu
 *
 */

@Aspect
@Component
public class LogManager {

		/**
		 * determine which package to bu cut
		 */
       @Pointcut("  execution(* com.clearsettle.controller.impl..*(..))")
       public void auditLog() {}

       /**
		 * determine which package to bu cut
		 */
       @Pointcut("  execution(* com.clearsettle.controller.impl..*(..))")
       public void performanceLog(){}

}
