package com.dct.Simple_Project.error;

import com.dct.Simple_Project.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidAgeException.class)
    public ResponseEntity<ErrorMessage> invalidAgeException(InvalidAgeException exception,
                                                            WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST,
                exception.getMessage());

        return ResponseEntity.status(errorMessage.getHttpStatus())
                .body(errorMessage);
    }

    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<ErrorMessage> studentNotFound(StudentNotFound exception,
                                                            WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND,
                exception.getMessage());

        return ResponseEntity.status(errorMessage.getHttpStatus())
                .body(errorMessage);
    }

    @ExceptionHandler(InvalidNameException.class)
    public ResponseEntity<ErrorMessage> invalidNameException(InvalidNameException exception,
                                                            WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST,
                exception.getMessage());

        return ResponseEntity.status(errorMessage.getHttpStatus())
                .body(errorMessage);
    }
}
