package dev.quixaba.cadastro_de_ninjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
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
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> lista = ninjaService.listarNinjas();
        if (lista != null) {
            return ResponseEntity.ok(lista);
        }else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<NinjaDTO> listarNinjaPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.buscarNinjaPorId(id);
        if (ninjaService.buscarNinjaPorId(id) != null) {
            return ResponseEntity.ok(ninja);
        }else {
            //retorna null por que não existe Objeto a ser retornado
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    //Alterar dados dos ninjas
    @PutMapping("/alterar/{id}")
    public ResponseEntity<NinjaDTO> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
       NinjaDTO ninja = ninjaService.alterarNinja(id, ninjaAtualizado);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    //Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {

        if (ninjaService.buscarNinjaPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com o ID " + id + " deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja de ID : " + id + " não foi encontrado");
        }
    }

}
