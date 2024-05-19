package by.bsuir.prokofyev.binanceproject.counter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import by.bsuir.prokofyev.binanceproject.counter.RequestCounterService;

@Aspect
@Component
class RequestCounterAspect {
    RequestCounterService requestCounterService;

    public RequestCounterAspect(RequestCounterService requestCounterService) {
        this.requestCounterService = requestCounterService;
    }

    @Around("@within(by.bsuir.prokofyev.binanceproject.counter.RequestStats) ||"
            + " @annotation(by.bsuir.prokofyev.binanceproject.counter.RequestStats)")
    public Object incrementRequestStats(ProceedingJoinPoint joinPoint) throws Throwable {
        requestCounterService.increment();
        return joinPoint.proceed();
    }
}