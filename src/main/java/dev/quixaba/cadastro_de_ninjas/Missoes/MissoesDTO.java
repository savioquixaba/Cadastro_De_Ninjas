package dev.quixaba.cadastro_de_ninjas.Missoes;

import dev.quixaba.cadastro_de_ninjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {


    private long id;

    private String nome_missao;

    private String dificuldade;

    // deixa o codigo com referencia circular porem é conceito avançado.
    private List<NinjaModel> ninjas;


}
