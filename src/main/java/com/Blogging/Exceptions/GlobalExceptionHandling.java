package com.Blogging.Exceptions;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Blogging.Payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandling {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String message= ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		Map<String, String> resp=new HashMap<>();
	ex.getBindingResult().getAllErrors().forEach((error)->{
		String FieldName= ((FieldError)error).getField();
		String Message=error.getDefaultMessage();
		resp.put(FieldName, Message);
	});
		
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
}
