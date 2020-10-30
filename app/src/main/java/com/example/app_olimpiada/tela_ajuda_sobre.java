package com.example.app_olimpiada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class tela_ajuda_sobre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_ajuda);

        Intent conteudo_tela = getIntent();
        if (conteudo_tela != null){
            Bundle parametros = conteudo_tela.getExtras();
            if (parametros != null){
                int texto = parametros.getInt("conteudo");
                String titulo = parametros.getString("titulo");
                TextView txt_titulo = findViewById(R.id.titulo_sobre_ajuda);
                TextView txt_conteudo = findViewById(R.id.conteudo_sobre_ajuda);
                txt_titulo.setText(titulo);
                txt_conteudo.setText(getString(texto));
            }
        }
    }
}