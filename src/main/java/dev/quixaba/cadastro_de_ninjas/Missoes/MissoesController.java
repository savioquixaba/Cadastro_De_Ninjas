package dev.quixaba.cadastro_de_ninjas.Missoes;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {


    @PostMapping("/Criar")
    public String criarMissao(){
        return "Missao criada";
    }


    @GetMapping ("/listar")
    public String listarMissao(){
        return "Missoes listadas com sucesso";
    }


    @PutMapping("/alterarID")
    public String alterarMissaoPorId(){
        return "Missao alterada com sucesso";
    }

    //Precisa ser por ID por que se não for, deleta todas as missões no banco
    @DeleteMapping("/deletarID")
    public String deletarMissaoPorId(){
        return "Missao deletada com sucesso";
    }

}
