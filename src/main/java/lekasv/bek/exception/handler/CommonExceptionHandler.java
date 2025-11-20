package lekasv.bek.exception.handler;

import lekasv.bek.dto.error.CommonErrorResponse;
import lekasv.bek.exception.base.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CommonErrorResponse> handle(NotFoundException e) {
        CommonErrorResponse commonErrorResponse = CommonErrorResponse.builder()
                .errorMessage(e.getMessage())
                .build();
        return new ResponseEntity<>(commonErrorResponse, HttpStatus.NOT_FOUND);
    }
}
