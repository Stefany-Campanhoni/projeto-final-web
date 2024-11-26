package br.com.stefanycampanhoni.projeto_final_web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class DomainToResponseConverter {
    public static <T> ResponseEntity<T> toResponse(T body, HttpStatus status) {
        return ResponseEntity.status(status).body(body);
    }
}
