package wagner.personapi.controller;


import lombok.AllArgsConstructor;
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
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor =  @__(@Autowired))
public class PersonController {

    private PersonService personService;


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

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable  Long id,@RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(id, personDTO);


    }





}
