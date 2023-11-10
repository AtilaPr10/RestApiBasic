package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.validation.FieldError;

@ControllerAdvice
public class ValidationExceptionHandler {
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorDto exceptionHandler(MethodArgumentNotValidException ex) {
		
		Map<String,String> mapCamposComErro = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String filedName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			mapCamposComErro.put(filedName, errorMessage);
			
		});
		
		 return new ErrorDto(mapCamposComErro);
		
	}
	
	

}
