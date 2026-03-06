package dev.quixaba.cadastro_de_ninjas.Ninjas;

import dev.quixaba.cadastro_de_ninjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private long id;
    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
    private MissoesModel missoes;
    private String rank;


}
