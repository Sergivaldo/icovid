package com.example.app_olimpiada;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Tela_inicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent_sobre_ajuda = new Intent(this,tela_ajuda_sobre.class);
        Bundle parametros = new Bundle();
        switch (item.getItemId()){
            case R.id.ajuda:
                parametros.putString("titulo","Ajuda");
                parametros.putInt("conteudo",R.string.Ajuda);
                intent_sobre_ajuda.putExtras(parametros);
                startActivity(intent_sobre_ajuda);
                return true;
            case R.id.sobre:
                parametros.putString("titulo","Sobre");
                parametros.putInt("conteudo",R.string.Sobre);
                intent_sobre_ajuda.putExtras(parametros);
                startActivity(intent_sobre_ajuda);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tela_covid(View view) {
        Intent covid_intent = new Intent(getApplicationContext(),Tela_covid.class);
        LinearLayout btt_covid = findViewById(R.id.btt_covid);
        startActivity(covid_intent);

    }
    public void tela_casa(View view) {
        Intent casa_intent = new Intent(getApplicationContext(),Tela_casa.class);
        LinearLayout btt_casa = findViewById(R.id.btt_casa);
        startActivity(casa_intent);

    }
    public void tela_escola(View view) {
        Intent escola_intent = new Intent(getApplicationContext(),Tela_escola.class);
        LinearLayout btt_escola = findViewById(R.id.btt_escola);
        startActivity(escola_intent);
    }
    public void tela_inicial(View view) {
        Intent inicial_intent = new Intent(getApplicationContext(),Tela_inicial.class);
        LinearLayout btt_inicial = findViewById(R.id.btt_covid);
        startActivity(inicial_intent);

    }

    public void conteudo(View view) {
        CardView card_distanciamento = findViewById(R.id.distanciamento);
        CardView card_alcool = findViewById(R.id.alcool);
        CardView card_mascara = findViewById(R.id.mascara);
        CardView card_isolamento = findViewById(R.id.isolamento);
        Intent intent_conteudo_cards = new Intent(this,conteudo_cards.class);
        Bundle parametros = new Bundle();
        if (view == card_distanciamento){
            parametros.putString("titulo","Distanciamento social");
            parametros.putInt("conteudo",R.string.conteudo_distanciamento);
            intent_conteudo_cards.putExtras(parametros);
            startActivity(intent_conteudo_cards);
        }else if (view == card_alcool){
            parametros.putString("titulo","Uso do alcool para higienização");
            parametros.putInt("conteudo",R.string.conteudo_alcool);
            intent_conteudo_cards.putExtras(parametros);
            startActivity(intent_conteudo_cards);
        }else if (view == card_mascara){
            parametros.putString("titulo","Uso da mascara");
            parametros.putInt("conteudo",R.string.conteudo_mascara);
            intent_conteudo_cards.putExtras(parametros);
            startActivity(intent_conteudo_cards);
        }else if(view == card_isolamento){
            parametros.putString("titulo","Isolamento social");
            parametros.putInt("conteudo",R.string.conteudo_isolamento);
            intent_conteudo_cards.putExtras(parametros);
            startActivity(intent_conteudo_cards);
        }


    }
}