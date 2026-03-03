package dev.quixaba.cadastro_de_ninjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
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


}

