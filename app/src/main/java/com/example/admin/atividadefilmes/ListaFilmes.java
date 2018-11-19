package com.example.admin.atividadefilmes;

import java.util.ArrayList;

public class ListaFilmes {

    private static ArrayList<Filme> listaFilme = new ArrayList<>();

    public static void addFilme(Filme filme){
        listaFilme.add(filme);
    }

    public static Filme getFilme(int index){
        return listaFilme.get(index);
    }

    public static ArrayList<Filme> getListaFilme(){
        return listaFilme;
    }

    public static void deletarFilme(int index){
        listaFilme.remove(index);
    }
}
