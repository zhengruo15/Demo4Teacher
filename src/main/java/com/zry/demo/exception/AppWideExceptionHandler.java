package com.zry.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppWideExceptionHandler {
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(){
		return "error";
	}
}
