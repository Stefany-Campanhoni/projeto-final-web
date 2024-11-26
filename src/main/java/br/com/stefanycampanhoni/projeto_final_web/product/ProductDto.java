package br.com.stefanycampanhoni.projeto_final_web.product;

import org.hibernate.validator.constraints.Length;

public record ProductDto(
        Integer barcode,
        @Length(max = 100) String name,
        @Length(max = 255) String description,
        Integer stockQuantity,
        ProductSituation situation
) {
}
