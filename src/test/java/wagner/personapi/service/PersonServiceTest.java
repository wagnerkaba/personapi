package wagner.personapi.service;

import org.aspectj.bridge.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.MessageCodesResolver;
import wagner.personapi.dto.request.PersonDTO;
import wagner.personapi.dto.response.MessageResponseDTO;
import wagner.personapi.entity.Person;
import wagner.personapi.mapper.PersonMapper;
import wagner.personapi.repository.PersonRepository;
import wagner.personapi.utils.PersonUtils;

import static wagner.personapi.utils.PersonUtils.*;
import static org.mockito.Mockito.any;


@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO(); //import static PersonUtils
        Person expectedSavedPerson = createFakeEntity(); //import static PersonUtils

        //Mockito.when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
        Mockito.when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());

        MessageResponseDTO successMessage = personService.createPerson(personDTO);

        Assertions.assertEquals(expectedSuccessMessage, successMessage);
    }
    private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId){
        return MessageResponseDTO.builder()
                .mensagem("Created person with ID: " + savedPersonId)
                .build();
    }

}
