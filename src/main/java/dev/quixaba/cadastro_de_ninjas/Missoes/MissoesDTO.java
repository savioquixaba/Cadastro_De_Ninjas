package dev.quixaba.cadastro_de_ninjas.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.quixaba.cadastro_de_ninjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
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

    private List<NinjaModel> ninjas;
}
