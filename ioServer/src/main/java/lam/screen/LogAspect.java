package lam.screen;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class LogAspect {
	
	Logger logger = LoggerFactory.getLogger(LogAspect.class);
	@Around("execution(* lam.screen.SimpleClientCore.*(..))")
	public void logEnhance(ProceedingJoinPoint jp) throws Throwable{
		
		logger.debug(jp.getSignature().getName()+"======");
		jp.proceed();
	}
	
	
	

}
