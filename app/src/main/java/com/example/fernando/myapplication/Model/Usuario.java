package com.example.fernando.myapplication.Model;

/**
 * Created by Fernando on 08/01/2018.
 */

public class Usuario {
    private Long id;
    private String nome;
    private String telefone;

    public Long getId(){
        return id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
