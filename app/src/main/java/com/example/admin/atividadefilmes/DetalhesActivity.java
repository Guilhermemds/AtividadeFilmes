package com.example.admin.atividadefilmes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetalhesActivity extends AppCompatActivity {

    TextView txtNomeDet;
    TextView txtGeneroDet;
    TextView txtAnoDet;
    TextView txtFormatoDet;
    Button btnDeletar;
    Button btnEditar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        txtNomeDet = findViewById(R.id.txtNomeDet);
        txtGeneroDet = findViewById(R.id.txtGeneroDet);
        txtAnoDet = findViewById(R.id.txtAnoDet);
        txtFormatoDet = findViewById(R.id.txtFormatoDet);
        btnDeletar = findViewById(R.id.btnDeletar);
        btnEditar = findViewById(R.id.btnEditar);

        final Intent intent =  getIntent();

        final Bundle bundle = intent.getExtras();

        final int index = bundle.getInt("index");
        String nome = bundle.getString("nome");
        String genero = bundle.getString("genero");
        int ano = bundle.getInt("ano");
        String formato = bundle.getString("formato");

        txtNomeDet.setText("Nome: " + nome);
        txtGeneroDet.setText("Gênero: " + genero);
        txtAnoDet.setText(String.valueOf("Ano: " + ano));
        txtFormatoDet.setText("Formato: " + formato);

        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListaFilmes.deletarFilme(index);
                Toast.makeText(DetalhesActivity.this, "Contato Excluído", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(DetalhesActivity.this, MainActivity.class));
            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editar = new Intent(DetalhesActivity.this, CadFilmeActivity.class);

                editar.putExtras(bundle);
                startActivity(editar);
            }
        });

    }
}
