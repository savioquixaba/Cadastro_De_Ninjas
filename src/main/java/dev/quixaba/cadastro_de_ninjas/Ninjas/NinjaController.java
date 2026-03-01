package dev.quixaba.cadastro_de_ninjas.Ninjas;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class NinjaController {
    
    @GetMapping("/Hello-world")
    public String helloWorld(){
        return "Olá Mundo meu primeiro Hello-World em Springboot";
    }

    //Adicionar ninja (Create)
    @PostMapping("/adicionar")
    public String adicionarNinja(){
        return "ninja Criado";
    }
    //Mostrar todos os ninjas(READ)
    @GetMapping("/todos")
    public String mostrarNinja(){
        return "lista de ninjas";
    }
    //Mostrar Ninja por ID (READ)
    @GetMapping("/todosID")
    public String mostrarNinjaPorId(){
        return "mostrar ninja por id";
    }
    //Alterar dados dos ninjas
    @PutMapping("/alterar")
    public String alterarNinja(){
        return "ninja alterado";
    }
    //Deletar Ninja
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "ninja deletado";
    }
}
