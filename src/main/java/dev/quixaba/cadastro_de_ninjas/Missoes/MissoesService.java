package dev.quixaba.cadastro_de_ninjas.Missoes;

import dev.quixaba.cadastro_de_ninjas.Ninjas.NinjaDTO;
import dev.quixaba.cadastro_de_ninjas.Ninjas.NinjaMapper;
import dev.quixaba.cadastro_de_ninjas.Ninjas.NinjaModel;
import dev.quixaba.cadastro_de_ninjas.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {


    private final NinjaMapper ninjaMapper;
    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper, NinjaMapper ninjaMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
        this.ninjaMapper = ninjaMapper;
    }

    public List<MissoesSimplesDTO> listarMissoes() {
        //inicializa a variavel e armazena a lista de missoes
        List<MissoesModel> missoes = missoesRepository.findAll();
        // o map vai percorrer a lista, e para cada item na lista do model, vai transformar para DTO
        return missoes.stream().map(missao -> missoesMapper.mapSimples(missao)).collect(Collectors.toList());
    }



    public MissoesSimplesDTO listarPorId(Long id){
        // Busca a missão pelo ID no banco de dados
        // findById sempre executa a consulta e retorna um Optional
        Optional<MissoesModel> missaoId = missoesRepository.findById(id);
        // orElse(null): retorna o objeto se encontrado, ou null se não existir
        return missaoId.map(missao -> missoesMapper.mapSimples(missao)).orElse(null);
    }


    public MissoesSimplesDTO criarMissao(MissoesSimplesDTO missao){
        MissoesModel novaMissao = missoesMapper.mapSimples(missao);
        novaMissao = missoesRepository.save(novaMissao);
        return missoesMapper.mapSimples(novaMissao);
    }

    public void deletarPorId(Long id){
         missoesRepository.deleteById(id);
    }
    public MissoesSimplesDTO alterarMissao(Long id, MissoesSimplesDTO  missaoSimples){
        Optional<MissoesModel> MissaoExistente = missoesRepository.findById(id);
        if (MissaoExistente.isPresent()){
            MissoesModel missaoAtt = missoesMapper.mapSimples(missaoSimples);
            missaoAtt.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtt);
            return missoesMapper.mapSimples(missaoSalva);
        }
        return null;
    }
}

