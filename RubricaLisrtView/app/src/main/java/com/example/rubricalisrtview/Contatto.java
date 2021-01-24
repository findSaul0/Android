package com.example.rubricalisrtview;

public class Contatto {

    int image;
    String numero;
    String nome;

    public int getImage() {
        return image;
    }

    public String getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public Contatto(String nome, String nuemro, int image){
        this.nome = nome;
        this.numero = nuemro;
        this.image = image;
    }
}
