package br.com.stefanycampanhoni.projeto_final_web.product;

import br.com.stefanycampanhoni.projeto_final_web.exception.NotFoundException;
import br.com.stefanycampanhoni.projeto_final_web.movement.MovementType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public Product create(ProductDto newProduct) {
        Product product = new Product();
        product.setBarcode(newProduct.barcode());
        product.setName(newProduct.name());
        product.setDescription(newProduct.description());
        product.setStockQuantity(newProduct.stockQuantity());
        product.setSituation(newProduct.situation());

        return repository.save(product);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product getProductById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado!"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Product update(Integer id, Product newProduct) {
        Product product = this.getProductById(id);

        product.setDescription(newProduct.getDescription());
        product.setName(newProduct.getName());
        product.setBarcode(newProduct.getBarcode());
        product.setStockQuantity(newProduct.getStockQuantity());
        product.setSituation(newProduct.getSituation());

        return product;
    }

    public Product updateStockQuantity(Integer id, Integer quantity, MovementType type) {
        Product product = this.getProductById(id);

        switch (type) {
            case ADD -> product.setStockQuantity(product.getStockQuantity() + quantity);
            case SUB -> product.setStockQuantity(product.getStockQuantity() - quantity);
        }

        return this.update(product.getId(), product);
    }
}
