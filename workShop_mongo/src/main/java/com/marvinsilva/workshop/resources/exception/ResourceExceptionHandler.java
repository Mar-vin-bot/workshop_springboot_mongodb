package com.marvinsilva.workshop.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.marvinsilva.workshop.services.exception.ObejectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObejectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObejectNotFoundException e,
			HttpServletRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		String mgn = "Não encontrado";
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), mgn, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}
}