package project.kiteshop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import project.kiteshop.service.LogService;

@Aspect
@Component
public class LogAspect {

    private final LogService logService;

    public LogAspect(LogService logService) {
        this.logService = logService;
    }

    @Pointcut("execution(* project.kiteshop.web.DetailsController.details(..))")
    public void detailsPointcut(){

    }


    @After("detailsPointcut()")
    public void afterAdvice(JoinPoint joinPoint){

        Object[] args = joinPoint.getArgs();
        Long productId = (Long) args[0];
        String action = joinPoint.getSignature().getName();

        logService.createLog(action, productId);
    }
}
