package one.digitalinnovation.personapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get")
public class GetTest {

    @GetMapping
    public String getTest(){
        return "Teste do GET efetuado com sucesso!";
    }
}
