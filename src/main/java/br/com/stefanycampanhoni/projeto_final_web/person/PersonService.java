package br.com.stefanycampanhoni.projeto_final_web.person;

import br.com.stefanycampanhoni.projeto_final_web.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository repository;

    public Person saveUser(PersonDto personDto) {
        Person person = new Person();

        person.setEmail(personDto.email());
        person.setPassword(personDto.password());

        return repository.save(person);
    }

    public Boolean login(PersonDto personDto) {
        Person person = this.findByEmail(personDto.email());
        return person.getPassword().equalsIgnoreCase(personDto.password());
    }

    private Person findByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Usuário não registrado!"));
    }
}
