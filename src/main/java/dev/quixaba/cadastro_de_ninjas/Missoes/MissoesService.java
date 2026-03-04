package dev.quixaba.cadastro_de_ninjas.Missoes;

import dev.quixaba.cadastro_de_ninjas.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private final NinjaRepository ninjaRepository;
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository, NinjaRepository ninjaRepository) {
        this.missoesRepository = missoesRepository;
        this.ninjaRepository = ninjaRepository;
    }

    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }


    public MissoesModel listarPorId(Long id){
        // Busca a missão pelo ID no banco de dados
        // findById sempre executa a consulta e retorna um Optional
        Optional<MissoesModel> missaoId = missoesRepository.findById(id);
        // orElse(null): retorna o objeto se encontrado, ou null se não existir
        return missaoId.orElse(null);
    }
    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    public void deletarPorId(Long id){
         missoesRepository.deleteById(id);
    }

}

