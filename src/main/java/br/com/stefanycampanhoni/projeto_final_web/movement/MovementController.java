package br.com.stefanycampanhoni.projeto_final_web.movement;

import br.com.stefanycampanhoni.projeto_final_web.DomainToResponseConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/movements")
public class MovementController {
    private final MovementService service;

    @GetMapping
    public ResponseEntity<List<Movement>> getAll() {
        return DomainToResponseConverter.toResponse(service.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movement> create(MovementDto movement) {
        return DomainToResponseConverter.toResponse(service.create(movement), HttpStatus.CREATED);
    }

}
