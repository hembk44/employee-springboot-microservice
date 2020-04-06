package com.imcs.employeeServiceApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class EmployeeRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleStudentException(
			EmployeeNotFoundException employeeNotFoundException) {

		EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();
		
		employeeErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		employeeErrorResponse.setMessage(employeeNotFoundException.getMessage());
		employeeErrorResponse.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(employeeErrorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleBadDataStudentException(BadDataException badDataException) {

		EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();

		employeeErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		employeeErrorResponse.setMessage(badDataException.getMessage());
		employeeErrorResponse.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(employeeErrorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleInternalServerException(InternalServerErrorException internalServerErrorException) {

		EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();

		employeeErrorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		employeeErrorResponse.setMessage(internalServerErrorException.getMessage());
		employeeErrorResponse.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(employeeErrorResponse, HttpStatus.BAD_REQUEST);
	}

}
