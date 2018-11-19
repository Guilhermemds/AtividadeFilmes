package com.example.admin.atividadefilmes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class FilmeAdapter extends RecyclerView.Adapter {

    private ArrayList<Filme> listaFilme;
    private Context context;


    public FilmeAdapter(ArrayList<Filme> listaFilme, Context context) {
        this.listaFilme = listaFilme;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.celula_filme, viewGroup, false);
        FilmeHolder holder = new FilmeHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {

        final FilmeHolder filmeHolder = (FilmeHolder)viewHolder;

        filmeHolder.txtNomeFilme.setText(listaFilme.get(i).getNome());




        filmeHolder.txtNomeFilme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Filme f = ListaFilmes.getFilme(i);

                Bundle detalhes = new Bundle();
                detalhes.putInt("index", i);
                detalhes.putString("nome", f.getNome());
                detalhes.putString("genero", f.getGenero());
                detalhes.putInt("ano", f.getAno());
                detalhes.putString("formato", f.getFormato());

                Intent intent = new Intent(context, DetalhesActivity.class );

                intent.putExtras(detalhes);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaFilme.size();
    }
}
