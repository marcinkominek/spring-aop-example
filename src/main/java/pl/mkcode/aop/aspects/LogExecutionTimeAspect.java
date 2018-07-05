package pl.mkcode.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LogExecutionTimeAspect {

    private static Logger logger = Logger.getLogger(LogExecutionTimeAspect.class.getName());

    @After("@annotation(pl.mkcode.aop.annotations.Logged)")
    public void afterLogged(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.info(methodName + ": after Logged");
    }

    @Before("@annotation(pl.mkcode.aop.annotations.Logged)")
    public void beforeLogged(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.info(methodName + ": before Logged ");
    }

    @Around("@annotation(pl.mkcode.aop.annotations.Logged)")
    public Object aroundLogged(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        logger.info(methodName + ": around start");
        Object retval = pjp.proceed();
        logger.info(methodName + ": around end");

        return retval;
    }
}
