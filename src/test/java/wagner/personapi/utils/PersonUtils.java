package wagner.personapi.utils;

import wagner.personapi.dto.request.PersonDTO;
import wagner.personapi.entity.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {
    public static final String FIRST_NAME = "Jamanta";
    public static final String LAST_NAME = "Da Silva";
    public static final String CPF_NUMBER = "369.333.878-79";
    public static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static PersonDTO createFakeDTO(){
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("04-04-2010")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity(){
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }


}
