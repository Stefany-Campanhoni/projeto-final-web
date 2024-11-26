package br.com.stefanycampanhoni.projeto_final_web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class ApiResponseHelper {
    public static <T> ResponseEntity<T> toResponse(T body, HttpStatus status) {
        return ResponseEntity.status(status).body(body);
    }

    public static ResponseEntity<String> toErrorResponse(String err, HttpStatus status) {
        return ResponseEntity.status(status).body(err);
    }

    public static ResponseEntity<Void> deleteResponse() {
        return ResponseEntity.noContent().build();
    }
}
