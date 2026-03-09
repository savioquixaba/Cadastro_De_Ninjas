package dev.quixaba.cadastro_de_ninjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){

        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado com sucesso: " + novoNinja.getNome() + " , " + "ID: " + novoNinja.getId());
    }

    //Mostrar todos os ninjas(READ)
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas(){

        return ninjaService.listarNinjas();
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public NinjaDTO listarNinjaPorId(@PathVariable Long id){
        return ninjaService.buscarNinjaPorId(id);
    }
    //Alterar dados dos ninjas
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.alterarNinja(id, ninjaAtualizado);

    }

    //Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }
}
