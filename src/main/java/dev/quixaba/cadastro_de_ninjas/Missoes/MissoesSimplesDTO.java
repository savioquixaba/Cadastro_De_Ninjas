package dev.quixaba.cadastro_de_ninjas.Missoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesSimplesDTO {

    private long id;

    private String nome_missao;

    private String dificuldade;
}
