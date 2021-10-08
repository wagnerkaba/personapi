package wagner.personapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import wagner.personapi.dto.response.MessageResponseDTO;
import wagner.personapi.entity.Person;
import wagner.personapi.repository.PersonRepository;
import wagner.personapi.service.PersonService;

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
    public MessageResponseDTO createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }
}
