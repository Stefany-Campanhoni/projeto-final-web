package br.com.stefanycampanhoni.projeto_final_web.movement;

import br.com.stefanycampanhoni.projeto_final_web.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "movement")
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private MovementType type;

    @Column(name = "product_quantity")
    private Integer productQuantity;

    private Product product;
}
