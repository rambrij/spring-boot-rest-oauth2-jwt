package com.ram.javacoderhint.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.time.Instant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler implements AuthenticationEntryPoint{
	
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
         ErrorDetails errorDetails = new ErrorDetails(Instant.now().toString(), ex.getMessage(), request.getDescription(false));
         errorDetails.setStatus(HttpStatus.NOT_FOUND);
         return new ResponseEntity<>(errorDetails, errorDetails.getStatus());
    }
    
    
	/*
	 * @Override public void commence(HttpServletRequest request,
	 * HttpServletResponse response, AuthenticationException authException) throws
	 * IOException, ServletException { // 401
	 * response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
	 * "Authentication Failed" + authException.getMessage());
	 * 
	 * }
	 */	  
  
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
		ErrorDetails apiResponse = new ErrorDetails(HttpStatus.UNAUTHORIZED, Instant.now().toString(), "Authentication Failed", authException.getMessage());
		OutputStream outputStream = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(outputStream, apiResponse);
		outputStream.flush();
	}  

	/*
	 * @ExceptionHandler (value = {AccessDeniedException.class}) public void
	 * commence(HttpServletRequest request, HttpServletResponse response,
	 * AccessDeniedException accessDeniedException) throws IOException { // 403
	 * response.sendError(HttpServletResponse.SC_FORBIDDEN,
	 * "Authorization Failed : " + accessDeniedException.getMessage()); }
	 */
  
   // 403
	@ExceptionHandler(AccessDeniedException.class)
	public void commence(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
		ErrorDetails apiResponse = new ErrorDetails(HttpStatus.FORBIDDEN, Instant.now().toString(), "Authorization Failed", accessDeniedException.getMessage());
		OutputStream outputStream = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(outputStream, apiResponse);
		outputStream.flush();
	}

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(Instant.now().toString(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}