package com.example.admin.atividadefilmes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadFilmeActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtGenero;
    private EditText edtAno;
    private EditText edtFormato;
    private Button btnSalvar;

    private boolean editar;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_filme);

        edtNome = findViewById(R.id.edtNome);
        edtGenero = findViewById(R.id.edtGenero);
        edtAno = findViewById(R.id.edtAno);
        edtFormato = findViewById(R.id.edtFormato);
        btnSalvar = findViewById(R.id.btnSalvar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            editar = true;

            index = bundle.getInt("index");
            String nome = bundle.getString("nome");
            String genero = bundle.getString("genero");
            int ano = bundle.getInt("ano");
            String formato = bundle.getString("formato");

            edtNome.setText(nome);
            edtGenero.setText(genero);
            edtAno.setText(ano);
            edtGenero.setText(formato);
        }else{
            editar = false;
        }

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtNome.getText().toString().isEmpty() || edtGenero.getText().toString().isEmpty() || edtGenero.getText().toString().isEmpty() ||
                        edtFormato.getText().toString().isEmpty()){
                    Toast.makeText(CadFilmeActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }else{

                    String nome = edtNome.getText().toString();
                    String genero = edtGenero.getText().toString();
                    int ano = Integer.parseInt(edtAno.getText().toString());
                    String formato = edtFormato.getText().toString();

                    //String.valueOf()

                    if(editar){

                        Filme edt = ListaFilmes.getFilme(index);

                        edt.setNome(nome);
                        edt.setGenero(genero);
                        edt.setAno(ano);
                        edt.setFormato(formato);

                        Toast.makeText(CadFilmeActivity.this, "Contato editado !", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(CadFilmeActivity.this, MainActivity.class));
                    }else {
                        Filme f = new Filme(nome, genero, ano, formato);

                        ListaFilmes.addFilme(f);

                        Toast.makeText(CadFilmeActivity.this, "Contato salvo", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(CadFilmeActivity.this, MainActivity.class));
                    }

                }
            }
        });


    }
}
