package br.com.stefanycampanhoni.projeto_final_web.exception;

import br.com.stefanycampanhoni.projeto_final_web.ApiResponseHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException err) {
        return ApiResponseHelper.toErrorResponse(err.getMessage(), HttpStatus.NOT_FOUND);
    }
}

