package com.example.admin.atividadefilmes;

public class Filme {

    String nome;
    String genero;
    int ano;
    String formato;

    public Filme(String nome, String genero, int ano, String formato) {
        this.nome = nome;
        this.genero = genero;
        this.ano = ano;
        this.formato = formato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}
