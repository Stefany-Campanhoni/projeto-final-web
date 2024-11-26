package br.com.stefanycampanhoni.projeto_final_web.product;

import br.com.stefanycampanhoni.projeto_final_web.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public Product create(Product newProduct) {
        return repository.save(newProduct);
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
}
