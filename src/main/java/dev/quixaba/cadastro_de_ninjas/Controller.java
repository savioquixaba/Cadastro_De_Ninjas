package dev.quixaba.cadastro_de_ninjas;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping
public class Controller {
    
    @GetMapping("/Hello-world")
    public String helloWorld(){
        return "Olá Mundo meu primeiro Hello-World em Springboot";
    }
    
    
}
