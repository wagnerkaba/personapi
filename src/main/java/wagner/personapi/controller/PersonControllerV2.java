package wagner.personapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import wagner.personapi.dto.request.PersonDTO;
import wagner.personapi.dto.response.MessageResponseDTO;
import wagner.personapi.entity.Person;
import wagner.personapi.exception.PersonNotFoundException;
import wagner.personapi.repository.PersonRepository;
import wagner.personapi.service.PersonService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v2/people")

public class PersonControllerV2 {

    private PersonService personService;

    @Autowired
    public PersonControllerV2(PersonService personService){

        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();


    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.deleteById(id);
    }

}
