package pl.mkcode.aop.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LogExecutionTimeAspect {

    private static Logger logger = Logger.getLogger(LogExecutionTimeAspect.class.getName());

    @After("@annotation(pl.mkcode.aop.annotations.Logged)")
    public void afterLogged() {
        logger.info("after Logged");
    }

    @Before("@annotation(pl.mkcode.aop.annotations.Logged)")
    public void beforeLogged(){
        logger.info("before Logged");
    }
}
