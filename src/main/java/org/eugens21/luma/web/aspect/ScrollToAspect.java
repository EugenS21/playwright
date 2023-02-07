package org.eugens21.luma.web.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.eugens21.luma.web.functional.ScrollTo;
import org.eugens21.luma.web.pages.elements.interfaces.Element;

@Aspect
@Slf4j
public class ScrollToAspect {

    @Before("@annotation(scrollTo)")
    public void doScrollTo(JoinPoint joinPoint, ScrollTo scrollTo) {
        ((Element) joinPoint.getTarget()).getLocator().scrollIntoViewIfNeeded();
    }


}
