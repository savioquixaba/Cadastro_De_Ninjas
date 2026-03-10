package dev.quixaba.cadastro_de_ninjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO){
        MissoesModel missoesModel = new MissoesModel();

        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome_missao(missoesDTO.getNome_missao());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setNinjas(missoesDTO.getNinjas());

        return missoesModel;
    }

    public MissoesDTO map(MissoesModel missoesModel){
        MissoesDTO missoesDTO = new MissoesDTO();

        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome_missao(missoesModel.getNome_missao());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());
        missoesDTO.setNinjas(missoesModel.getNinjas());

        return missoesDTO;
    }

    public MissoesSimplesDTO mapSimples(MissoesModel missoesModel){
        MissoesSimplesDTO missoesSimplesDTO = new MissoesSimplesDTO();

        missoesSimplesDTO.setId(missoesModel.getId());
        missoesSimplesDTO.setNome_missao(missoesModel.getNome_missao());
        missoesSimplesDTO.setDificuldade(missoesModel.getDificuldade());

        return missoesSimplesDTO;
    }
}
