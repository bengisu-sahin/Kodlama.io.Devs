package com.kodlamaiodevs.project;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kodlamaiodevs.project.business.core.utilities.exceptions.BusinessException;
import com.kodlamaiodevs.project.business.rules.ProblemDetails;
import com.kodlamaiodevs.project.business.rules.ValidationProblemDetails;



@SpringBootApplication
@RestControllerAdvice // This annotation is used to handle exceptions globally
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST) // This annotation is used to set the status code of the response
	public ProblemDetails handleBusinessException(BusinessException exception) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(exception.getMessage());
		return problemDetails;
	}
	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST) // This annotation is used to set the status code of the response
	public ProblemDetails handleValidationException(MethodArgumentNotValidException exception) {
		ValidationProblemDetails problemDetails = new ValidationProblemDetails();
		problemDetails.setMessage("VALIDATION.EXCEPTION");
		problemDetails.setValidationErrors(new HashMap<String, String>());
		exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
			problemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		});
		return problemDetails;
	}  
}
