package br.com.stefanycampanhoni.projeto_final_web.movement;

import java.util.function.BiFunction;

public enum MovementType {
    ADD(Integer::sum),
    SUB((currentStock, quantity) -> {
        if (currentStock < quantity)
            throw new IllegalArgumentException("Estoque insuficiente para essa operação");

        return currentStock - quantity;
    });

    private final BiFunction<Integer, Integer, Integer> operation;

    MovementType(BiFunction<Integer, Integer, Integer> operation) {
        this.operation = operation;
    }

    public Integer calculate(Integer stockQuantity, Integer quantity) {
        return operation.apply(stockQuantity, quantity);
    }
}
