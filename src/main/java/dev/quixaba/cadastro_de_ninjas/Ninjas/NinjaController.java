package dev.quixaba.cadastro_de_ninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/Hello-world")
    public String helloWorld(){
        return "Olá Mundo meu primeiro Hello-World em Springboot";
    }

    //Adicionar ninja (Create)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    //Mostrar todos os ninjas(READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){

        return ninjaService.listarNinjas();
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjaPorId(@PathVariable Long id){
        return ninjaService.buscarNinjaPorId(id);
    }
    //Alterar dados dos ninjas

    @PutMapping("/alterar")
    public String alterarNinjaPorId(){
        return "ninja alterado";
    }

    //Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }
}
