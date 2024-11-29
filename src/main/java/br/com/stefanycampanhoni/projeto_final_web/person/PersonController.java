package br.com.stefanycampanhoni.projeto_final_web.person;

import br.com.stefanycampanhoni.projeto_final_web.ApiResponseHelper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users")
public class PersonController {
    private final PersonService service;

    @PostMapping(path = "/register")
    public ResponseEntity<Person> registerUser(@Valid @RequestBody PersonDto personDto) {
        return ApiResponseHelper.toResponse(service.saveUser(personDto), HttpStatus.OK);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<Boolean> login(@Valid @RequestBody PersonDto personDto) {
        return ApiResponseHelper.toResponse(service.login(personDto), HttpStatus.OK);
    }
}
