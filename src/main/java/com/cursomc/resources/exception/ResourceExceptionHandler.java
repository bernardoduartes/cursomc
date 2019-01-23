package com.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cursomc.service.exceptions.DataIntegrityException;
import com.cursomc.service.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	private static final String ERRO_DE_VALIDACAO = "Erro de validação";

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNorFound(ObjectNotFoundException e, HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrityException(DataIntegrityException e, HttpServletRequest request){
		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request){
		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), ERRO_DE_VALIDACAO, System.currentTimeMillis());
		
		e.getBindingResult().getFieldErrors().forEach(
				(FieldError fieldError) -> err.addError(fieldError.getField(), fieldError.getDefaultMessage()));
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}
