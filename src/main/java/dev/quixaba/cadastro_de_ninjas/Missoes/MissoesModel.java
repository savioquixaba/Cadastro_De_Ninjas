package dev.quixaba.cadastro_de_ninjas.Missoes;

import dev.quixaba.cadastro_de_ninjas.Ninjas.NinjaModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private String nome_missao;
    private String dificuldade;
    
    //uma missao pode ter varios ninjas
    @OneToMany(mappedBy = "missoes") 
    private NinjaModel ninja;
    
    
}
