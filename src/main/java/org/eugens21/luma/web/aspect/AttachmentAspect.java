package org.eugens21.luma.web.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.eugens21.luma.web.utils.UiStep;

import java.time.LocalDateTime;

import static io.qameta.allure.Allure.getLifecycle;

@Aspect
@Slf4j
public class AttachmentAspect {

    @Pointcut("@annotation(org.eugens21.luma.web.functional.Attachment)")
    public void hasAttachmentAnnotation() {
    }

    @Pointcut("@within(org.eugens21.luma.web.functional.Attachment)")
    public void hasAttachmentClassAnnotation() {
    }

    @Pointcut("execution(* *(..))")
    public void methodExecution() {
    }

    @After("methodExecution() && (hasAttachmentAnnotation() || hasAttachmentClassAnnotation())")
    public void attachScreenshot(JoinPoint joinPoint) {
        byte[] screenshot = ((UiStep) joinPoint.getTarget()).getPage().screenshot();
        getLifecycle().addAttachment("Attachment ".concat(LocalDateTime.now().toString()),
                "image/png",
                "png",
                screenshot
        );
    }

}