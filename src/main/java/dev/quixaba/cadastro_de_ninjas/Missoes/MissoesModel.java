package dev.quixaba.cadastro_de_ninjas.Missoes;

import dev.quixaba.cadastro_de_ninjas.Ninjas.NinjaModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_missoes")
public class MissoesModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private String nome_missao;
    private String dificuldade;
    private NinjaModel ninja;
    
    public MissoesModel(){   
    }


    public MissoesModel(long id, String nome_missao, String dificuldade) {
        this.id = id;
        this.nome_missao = nome_missao;
        this.dificuldade = dificuldade;
    }


    public long getId() {
        return id;
    }

    public String getNome_missao() {
        return nome_missao;
    }


    public void setNome_missao(String nome_missao) {
        this.nome_missao = nome_missao;
    }


    public String getDificuldade() {
        return dificuldade;
    }


    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }
}
