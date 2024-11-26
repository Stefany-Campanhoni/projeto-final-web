package br.com.stefanycampanhoni.projeto_final_web.movement;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovementService {
    private final MovementRepository repository;

}
