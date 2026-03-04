package dev.quixaba.cadastro_de_ninjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> listarNinjas(){
        //precisa ser o alias dado na inicilização do objeto
        return ninjaRepository.findAll();
    }

    public NinjaModel buscarNinjaPorId(Long id){
        Optional<NinjaModel> NinjaId = ninjaRepository.findById(id);
        return NinjaId.orElse(null);

    }

    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }


    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }

    public NinjaModel alterarNinja(Long id, NinjaModel  ninjaAtualizado){
        //valida se o ID do ninja existe
        if (ninjaRepository.existsById(id)){
            //caso exista, seta o ID pro ninja atualizado
            ninjaAtualizado.setId(id);
            //e salva os dados do ninja atualizado
            return ninjaRepository.save(ninjaAtualizado);
        }
        // caso não exista, vem pro null
        return null;
    }
}
