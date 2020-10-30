package com.example.app_olimpiada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class conteudo_cards extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteudo_cards);
        Intent conteudo_tela = getIntent();
        if (conteudo_tela != null){
            Bundle parametros = conteudo_tela.getExtras();
            if (parametros != null){
                int imagem = parametros.getInt("imagem");
                int texto = parametros.getInt("conteudo");
                String titulo = parametros.getString("titulo");
                TextView txt_titulo = findViewById(R.id.titulo_conteudo);
                TextView txt_conteudo = findViewById(R.id.texto_conteudo);
                txt_titulo.setText(titulo);
                txt_conteudo.setText(getString(texto));
            }
        }
    }
}