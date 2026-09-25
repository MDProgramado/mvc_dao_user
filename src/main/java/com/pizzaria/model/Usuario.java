package com.pizzaria.model;

public class Usuario {
    private int id;
    private String nome;
    private String matricula;
    private String setor;



    public Usuario(){}

    public Usuario(String setor, String matricula, String nome) {
        this.setor = setor;
        this.matricula = matricula;
        this.nome = nome;
    }

    public Usuario(int id, String nome, String matricula, String setor) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.setor = setor;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }


}
