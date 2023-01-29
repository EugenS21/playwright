package org.eugens21.luma.web.aspect;

import com.microsoft.playwright.Locator;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.eugens21.luma.web.functional.WaitForState;

@Aspect
@Slf4j
public class WaitForStateAspect {

    @Before("@annotation(waitForState)")
    public void doWaitForState(JoinPoint joinPoint, WaitForState waitForState) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Locator) {
                Locator.WaitForOptions waitForOptions = new Locator.WaitForOptions();
                waitForOptions.setState(waitForState.value());
                log.debug("Waiting for {} to be {}", arg, waitForState.value());
                ((Locator) arg).waitFor(waitForOptions);
            }
        }
    }

}
