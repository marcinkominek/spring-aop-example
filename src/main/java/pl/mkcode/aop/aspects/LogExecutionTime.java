package pl.mkcode.aop.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogExecutionTime {

    @After("@annotation(pl.mkcode.aop.annotations.Logged)")
    public void doSth(){
        System.out.println("aspect");
    }
}
