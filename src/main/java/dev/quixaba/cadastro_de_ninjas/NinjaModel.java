package dev.quixaba.cadastro_de_ninjas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// transforma uma classe em uma entidade do BD
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private long id;
    private String nome;
    private String email;
    private int idade;


    public NinjaModel (){}

    public NinjaModel(String nome, String email, int idade){
        
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
