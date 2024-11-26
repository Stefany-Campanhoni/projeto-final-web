package br.com.stefanycampanhoni.projeto_final_web.movement;

public record MovementDto(
        MovementType type,
        Integer productQuantity,
        Integer productId
) {
}
