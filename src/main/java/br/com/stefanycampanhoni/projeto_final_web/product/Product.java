package br.com.stefanycampanhoni.projeto_final_web.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

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

    @Length(max = 100)
    private String name;

    @Length(max = 255)
    private String description;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    private ProductSituation situation;
}
