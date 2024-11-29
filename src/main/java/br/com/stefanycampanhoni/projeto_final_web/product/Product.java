package br.com.stefanycampanhoni.projeto_final_web.product;

import br.com.stefanycampanhoni.projeto_final_web.movement.Movement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer barcode;

    @Column(length = 100)
    private String name;

    private String description;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    private ProductSituation situation;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Movement> movements = new ArrayList<>();
}
