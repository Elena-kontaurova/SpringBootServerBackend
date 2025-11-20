package lekasv.bek.exception.handler;

import jakarta.validation.ConstraintViolationException;
import lekasv.bek.dto.error.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ValidationJakartaExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ValidationErrorResponse> handleValidationExceptions(MethodArgumentNotValidException e) {
        List<String> errorMessages = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();

        ValidationErrorResponse validationErrorResponse = ValidationErrorResponse.builder()
                .errorMessages(errorMessages)
                .build();

        return new ResponseEntity<>(validationErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ValidationErrorResponse> handleConstraintViolationException(ConstraintViolationException e) {
        List<String> errorMessages = e.getConstraintViolations()
                .stream()
                .map(error -> error.getPropertyPath() + ": " + error.getMessage())
                .toList();

        ValidationErrorResponse validationErrorResponse = ValidationErrorResponse.builder()
                .errorMessages(errorMessages)
                .build();

        return new ResponseEntity<>(validationErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
