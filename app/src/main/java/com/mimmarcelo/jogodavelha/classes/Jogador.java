package com.mimmarcelo.jogodavelha.classes;

public class Jogador {
    private long id;
    private String nome;
    private int idSimbolo;

    public Jogador(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdSimbolo() {
        return idSimbolo;
    }

    public void setIdSimbolo(int idSimbolo) {
        this.idSimbolo = idSimbolo;
    }
}
