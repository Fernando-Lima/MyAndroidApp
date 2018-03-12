package com.example.fernando.myapplication.Model;

/**
 * Created by Fernando on 11/03/2018.
 */

public class Grupo {
    private Long id;
    private String nome;
    private String descricao;
    private String regra;
    private Servico servico;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getRegra(){
        return regra;
    }
    public void setRegra(String regra){
        this.regra = regra;
    }
    public Servico getServico(){
        return servico;
    }
    public void setServico(Servico servico){
        this.servico = servico;
    }
}
