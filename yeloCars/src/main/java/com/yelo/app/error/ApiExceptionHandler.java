package com.yelo.app.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.yelo.app.error.ErrorDetails;

import javassist.NotFoundException;

@RestControllerAdvice
public class ApiExceptionHandler extends RuntimeException {
	
		@ExceptionHandler(value = {NotFoundException.class})
		public ResponseEntity <ErrorDetails> exception(Exception exception,WebRequest request) {
			ErrorDetails details=new ErrorDetails(exception.getLocalizedMessage(),request.getDescription(false),LocalDateTime.now());
		    return new  ResponseEntity<>(details, HttpStatus.NOT_FOUND);
		    }

	      
	
	@ExceptionHandler(value = {NullPointerException.class})
	public ResponseEntity <ErrorDetails> exception2(Exception exception,WebRequest request) {
		ErrorDetails details=new ErrorDetails(exception.getLocalizedMessage(),request.getDescription(false),LocalDateTime.now());
	    return new  ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	    }
         
	
		@ExceptionHandler(value = {Exception.class})
		public ResponseEntity <ErrorDetails> exception3(Exception exception,WebRequest request) {
			ErrorDetails details=new ErrorDetails(exception.getLocalizedMessage(),request.getDescription(false),LocalDateTime.now());
		    return new  ResponseEntity<>(details, HttpStatus.NOT_FOUND);
		    }

	


}
