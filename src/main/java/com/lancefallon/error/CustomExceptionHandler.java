package com.lancefallon.error;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * let certain errors bubble up to be handled here.
 * <br>
 * all methods return a ResponseEntity of a specified type as well as a status code
 * @author lancefallon
 *
 */
@ControllerAdvice
public class CustomExceptionHandler {
	@ExceptionHandler(BadCredentialsException.class)
    ResponseEntity<String> handleInvalidInputException(BadCredentialsException ex) throws IOException {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
