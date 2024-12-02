package br.com.stefanycampanhoni.projeto_final_web.product;

import br.com.stefanycampanhoni.projeto_final_web.ApiResponseHelper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/products")
public class ProductController {
    private final ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ApiResponseHelper.toResponse(service.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody ProductDto product) {
        return ApiResponseHelper.toResponse(service.create(product), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> getById(@PathVariable(name = "id") Integer id) {
        return ApiResponseHelper.toResponse(service.getProductById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
        service.delete(id);
        return ApiResponseHelper.deleteResponse();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Product> update(@PathVariable(name = "id") Integer id,
                                          @Valid @RequestBody ProductDto productDto) {
        return ApiResponseHelper.toResponse(service.update(id, productDto), HttpStatus.OK);
    }

}
