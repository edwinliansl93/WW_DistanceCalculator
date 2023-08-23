package org.ww.cal.exceptions.handler;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.ww.cal.dto.CalculateDistanceResDto;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        CalculateDistanceResDto<String> response = new CalculateDistanceResDto<>(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred: " + e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

