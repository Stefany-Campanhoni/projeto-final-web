package br.com.stefanycampanhoni.projeto_final_web.movement;

import br.com.stefanycampanhoni.projeto_final_web.product.Product;
import br.com.stefanycampanhoni.projeto_final_web.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovementService {
    private final MovementRepository repository;
    private final ProductService productService;

    public List<Movement> getAll() {
        return repository.findAll();
    }

    public Movement create(MovementDto movement) {
        Movement newMovement = new Movement();
        newMovement.setType(movement.type());
        newMovement.setProductQuantity(movement.productQuantity());

        Product product = productService.updateStockQuantity(movement.productId(), movement.productQuantity(), movement.type());
        newMovement.setProduct(product);

        return repository.save(newMovement);
    }
}
