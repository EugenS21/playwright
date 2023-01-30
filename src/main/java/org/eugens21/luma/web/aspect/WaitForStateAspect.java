package org.eugens21.luma.web.aspect;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.WaitForOptions;
import com.microsoft.playwright.options.WaitForSelectorState;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.eugens21.luma.web.functional.WaitForState;
import org.eugens21.luma.web.pages.elements.interfaces.Element;

import java.util.Arrays;

@Aspect
@Slf4j
public class WaitForStateAspect {

    @Before("@annotation(waitForState)")
    public void doWaitForState(JoinPoint joinPoint, WaitForState waitForState) {
        Object[] args = joinPoint.getArgs();
        if (containsLocatorAsArgument(args)) {
            for (Object arg : args) {
                if (arg instanceof Locator) {
                    ((Locator) arg).waitFor(waitForCondition(arg, waitForState.value()));
                }
            }
        } else {
            Locator locator = ((Element) joinPoint.getTarget()).getLocator();
            locator.waitFor(waitForCondition(locator, waitForState.value()));
        }
    }

    private boolean containsLocatorAsArgument(Object[] args) {
        return Arrays.stream(args).anyMatch(el -> el instanceof Locator);
    }

    private WaitForOptions waitForCondition(Object arg, WaitForSelectorState waitForSelectorState) {
        WaitForOptions waitForOptions = new WaitForOptions();
        waitForOptions.setState(waitForSelectorState);
        log.debug("Waiting for {} to be {}", arg, waitForSelectorState);
        return waitForOptions;
    }

}
