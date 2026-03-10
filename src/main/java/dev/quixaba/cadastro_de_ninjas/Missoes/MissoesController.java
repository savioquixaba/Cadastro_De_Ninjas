package dev.quixaba.cadastro_de_ninjas.Missoes;



import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/criar")
    public MissoesSimplesDTO criarMissao(@RequestBody MissoesSimplesDTO missao){
        return missoesService.criarMissao(missao);
    }


    @GetMapping ("/listar")
    public List<MissoesSimplesDTO> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping ("/listar/{id}")
    public MissoesSimplesDTO listarMissoesPorId(@PathVariable Long id){
        return missoesService.listarPorId(id);
    }


    @PutMapping("/alterarID")
    public MissoesSimplesDTO alterarNinjaPorId(@PathVariable Long id, @RequestBody MissoesSimplesDTO missaoAtt) {
        return missoesService.alterarMissao(id, missaoAtt);
    }
    //Precisa ser por ID por que se não for, deleta todas as missões no banco
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(@PathVariable Long id){
        missoesService.deletarPorId(id);
    }


}
