package dev.quixaba.cadastro_de_ninjas.Ninjas;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    
    @GetMapping("/Hello-world")
    public String helloWorld(){
        return "Olá Mundo meu primeiro Hello-World em Springboot";
    }

    //Adicionar ninja (Create)
    @PostMapping("/criar")
    public String criarNinja(){
        return "ninja Criado";
    }
    //Mostrar todos os ninjas(READ)
    @GetMapping("/listar")
    public String listarNinja(){
        return "lista de ninjas";
    }
    //Mostrar Ninja por ID (READ)
    @GetMapping("/listarID")
    public String mostrarNinjaPorId(){
        return "mostrar ninja por id";
    }
    //Alterar dados dos ninjas
    @PutMapping("/alterar")
    public String alterarNinjaPorId(){
        return "ninja alterado";
    }
    //Deletar Ninja
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "ninja deletado";
    }
}
