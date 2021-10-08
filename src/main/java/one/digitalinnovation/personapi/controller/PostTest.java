package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.entity.PersonTest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostTest {

    @PostMapping
    public String postTest(@RequestBody PersonTest teste){

        return "O texto recebido foi: " + teste.getFirstname();
    }
}
