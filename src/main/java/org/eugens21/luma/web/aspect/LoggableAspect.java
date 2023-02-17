package org.eugens21.luma.web.aspect;

import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@Aspect
@Slf4j
public class LoggableAspect {

    private PrintStream originalOut = System.out;
    private PrintStream originalErr = System.err;
    private ByteArrayOutputStream outStream;
    private ByteArrayOutputStream errStream;

    @Pointcut("@annotation(org.eugens21.luma.web.functional.Loggable)")
    public void hasLoggableAnnotation() {
    }

    @Pointcut("@within(org.eugens21.luma.web.functional.Loggable)")
    public void hasLoggableClassAnnotation() {
    }

    @Pointcut("execution(* *(..))")
    public void methodExecution() {
    }

    @Before("methodExecution() && (hasLoggableAnnotation() || hasLoggableClassAnnotation())")
    public void init(JoinPoint joinPoint) {
        outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));

        errStream = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errStream));
    }

    @After("methodExecution() && (hasLoggableAnnotation() || hasLoggableClassAnnotation())")
    public void attachLogs(JoinPoint joinPoint) {
        System.setOut(originalOut);
        System.setErr(originalErr);

        byte[] outBytes = outStream.toByteArray();
        byte[] errBytes = errStream.toByteArray();

        Allure.getLifecycle().addAttachment("Step Output",
                "text/plain",
                "txt",
                outBytes);

        Allure.getLifecycle().addAttachment("Error Output",
                "text/plain",
                "txt",
                errBytes);

    }

}