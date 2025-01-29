package io.myLogTrace.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestController
@ControllerAdvice
public class MyLogTraceExceptionHandler extends ResponseEntityExceptionHandler {
    //
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleException(Exception e) {
        //
        ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DuplicateDataException.class)
    public final ResponseEntity<ExceptionResponse> handleDuplicateDateException(DuplicateDataException e) {
        //
        ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
