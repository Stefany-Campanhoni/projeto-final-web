package br.com.stefanycampanhoni.projeto_final_web.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserDto(
        @Email(message = "Email inválido")
        String email,
        @Size(min = 8, message = "A senha deve ter ao menos 8 caracteres.")
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).*$",
                message = "A senha deve conter pelo menos um número e um símbolo.")
        String password
) {
}
