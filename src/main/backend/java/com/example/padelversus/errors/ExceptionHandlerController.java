package com.example.padelversus.errors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerController {

    Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public String defaultErrorHandler(HttpServletRequest request, Exception e) {
        logger.error("ERROR in request: " + request.getServletPath() + " exeception thrown " + e);
        e.printStackTrace();
        return "error";
    }
}