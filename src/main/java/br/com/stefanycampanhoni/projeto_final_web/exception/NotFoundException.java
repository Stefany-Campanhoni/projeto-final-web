package br.com.stefanycampanhoni.projeto_final_web.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
