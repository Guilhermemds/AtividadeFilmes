package com.example.admin.atividadefilmes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class FilmeHolder extends RecyclerView.ViewHolder{

    public TextView txtNomeFilme;
    public TextView txtVerMais;


    public FilmeHolder(@NonNull View itemView) {
        super(itemView);

        txtNomeFilme = itemView.findViewById(R.id.txtNomeFilme);
        txtVerMais = itemView.findViewById(R.id.txtVerMais);
    }
}
