package wagner.personapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import wagner.personapi.dto.request.PersonDTO;
import wagner.personapi.dto.response.MessageResponseDTO;
import wagner.personapi.entity.Person;
import wagner.personapi.exception.PersonNotFoundException;
import wagner.personapi.mapper.PersonMapper;
import wagner.personapi.repository.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        return createMessageResponseDTO(savedPerson.getId(), "Created person with ID ");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();

        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());


    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {

        Person person = verifyIfExists(id);

        return personMapper.toDTO(person);
    }


    public void deleteById(Long id) throws PersonNotFoundException {

        verifyIfExists(id);
        personRepository.deleteById(id);

    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(()-> new PersonNotFoundException(id));
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {

        verifyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);
        Person updatedPerson = personRepository.save(personToUpdate);
        return createMessageResponseDTO(updatedPerson.getId(), "Updated person with ID ");
    }

    private MessageResponseDTO createMessageResponseDTO(Long id, String message) {

        return MessageResponseDTO
                .builder()
                .mensagem(message + id)
                .build();
    }
}
