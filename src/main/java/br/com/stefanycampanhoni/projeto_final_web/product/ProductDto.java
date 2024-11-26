package br.com.stefanycampanhoni.projeto_final_web.product;

import org.hibernate.validator.constraints.Length;

public record ProductDto(
        Integer barcode,
        @Length(max = 100, message = "O nome deve possuir no máximo 100 caracteres") String name,
        @Length(max = 255, message = "A descrição deve ter no máximo 255 caracteres") String description,
        Integer stockQuantity,
        ProductSituation situation
) {
}
