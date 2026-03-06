package dev.quixaba.cadastro_de_ninjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> listarNinjas(){
       //inicializa a variavel ninjas que é do tipo listmodel
        List<NinjaModel> ninjas = ninjaRepository.findAll();
       //inicializa o stream
        return ninjas.stream()
              // o map vai percorrer a lista, e para cada item na lista do model, vai transformar para DTO
               .map(ninja -> ninjaMapper.map(ninja))
               // aqui ele pega o item transformado e bota dentro da lista e retorna
                .collect(Collectors.toList());
    }

    public NinjaDTO buscarNinjaPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId
                .map(ninja -> ninjaMapper.map(ninja))
                .orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        // o objeto ninjaDTO vira model novamente, e armazena na variavel ninja
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        //a variavel ninja é salva
        ninja = ninjaRepository.save(ninja);
        //a variavel ninja retorna e vira DTO novamente
        return ninjaMapper.map(ninja);
        //o metodo do mapper recebe o model e transforma para DTO, devolvendo o objeto correto
    }


    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO alterarNinja(Long id, NinjaDTO  ninjaDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }
}
