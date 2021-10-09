package wagner.personapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import wagner.personapi.dto.request.PersonDTO;
import wagner.personapi.dto.response.MessageResponseDTO;
import wagner.personapi.entity.Person;
import wagner.personapi.mapper.PersonMapper;
import wagner.personapi.repository.PersonRepository;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);

        return MessageResponseDTO
                .builder()
                .mensagem("Created person with ID " + savedPerson.getId())
                .build();
    }

}
