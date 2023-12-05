package org.group28projectjpa_21_11.configureition;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingConfigureition {
    @Pointcut("execution(public* org.group28projectjpa_21_11.controllers.*.*(..))")
    public void controllerLog() {
    }

    @Pointcut("execution(public* org.group28projectjpa_21_11.core.services.*.*(..))")
    public void serviceLog() {
    }


    @Pointcut("execution(public* org.group28projectjpa_21_11.core.utils.*.*(..))")
    public void utilsLog() {
    }

    @Pointcut("execution(public* org.group28projectjpa_21_11.databaseMigration.v1.DatabaseConfig.fillRoleTable(..))")
    public void configLog() {
    }


    @Before("controllerLog()")
    public void doBeforeControllerLog(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        log.info("\n NEW REQUEST: \n IP: {}\n URL: {}\n HTTP_METHOD; {}\n CONTROLLER_METHOD: {}.{}",
                request.getRemoteAddr(),
                request.getRequestURL().toString(),
                request.getMethod(),
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
    }

    @Before("serviceLog()")
    public void doBeforeServiceLog(JoinPoint joinPoint) {
        log.info(" RUN SERVICE: \n SERVICE_METHOD: {}.{}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
    }

    @Before("utilsLog()")
    public void doBeforeUtilseLog(JoinPoint joinPoint){
        log.info("RUN UTILS:\n UTILS_METOD:{}.{}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
    }

    @Before("configLog()")
    public void doBeforeConfigLog(JoinPoint joinPoint) {
        log.info("Starting to fill role table");
    }

    @AfterReturning(returning = "returnObject", pointcut = "controllerLog()")
    public void doAfterReturn(Object returnObject) {
        if (log.isInfoEnabled()) {
            log.info("RETURN VALUE: {}\n END REQUEST!", returnObject);
        }
    }

    @AfterThrowing(throwing = "exception", pointcut = "controllerLog()")
    public void throwException(JoinPoint joinPoint, Exception exception) {
        log.error(" Request throw an exception. Cause - {}.{}",
                Arrays.toString(joinPoint.getArgs()), exception.getMessage());
    }

    @AfterThrowing(throwing = "exception", pointcut = "utilsLog()")
    public void throwExceptionForUtils(JoinPoint joinPoint, Exception exception) {
        log.error("Request throw an exception in UTILS. Cause - {}: {}",
                Arrays.toString(joinPoint.getArgs()),
                exception.getMessage());
    }

    @After("configLog()")
    public void doAfterConfigLog(JoinPoint joinPoint) {
        log.info("Completed execution of: {}.{} with arguments: {}\n END REQUEST!",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));
    }


    @AfterThrowing(pointcut = "configLog()", throwing = "exception")
    public void doAfterThrowingConfigLog(JoinPoint joinPoint, Throwable exception) {
        log.error("Exception occurred in fillRoleTable: {}", exception.getMessage(), exception);
    }
}
