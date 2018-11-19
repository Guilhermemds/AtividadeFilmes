package com.example.admin.atividadefilmes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCadastrar;
    RecyclerView rclFilmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rclFilmes = findViewById(R.id.rclFilmes);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        FilmeAdapter filmeAdapter = new FilmeAdapter(ListaFilmes.getListaFilme(), MainActivity.this);

        rclFilmes.setAdapter(filmeAdapter);

        RecyclerView.LayoutManager meuLayout = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

        rclFilmes.setLayoutManager(meuLayout);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CadFilmeActivity.class));
            }
        });
    }
}