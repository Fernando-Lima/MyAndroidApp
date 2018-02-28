package com.example.fernando.myapplication.Model;

/**
 * Created by Fernando on 15/01/2018.
 */

public class Servico {
    private Long id;
    private String nome;
    private String descricao;
    private Long IdCategoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(Long IdCategoria) {
        this.IdCategoria = IdCategoria;
    }
}
