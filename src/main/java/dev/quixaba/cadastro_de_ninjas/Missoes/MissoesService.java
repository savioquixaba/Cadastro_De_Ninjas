package dev.quixaba.cadastro_de_ninjas.Missoes;

import dev.quixaba.cadastro_de_ninjas.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {


    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;

    }

    public List<MissoesSimplesDTO> listarMissoes() {
        //inicializa a variavel e armazena a lista de missoes
        List<MissoesModel> missoes = missoesRepository.findAll();
        // o map vai percorrer a lista, e para cada item na lista do model, vai transformar para DTO
        return missoes.stream().map(missao -> missoesMapper.mapSimples(missao)).collect(Collectors.toList());
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

