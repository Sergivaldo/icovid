package com.example.app_olimpiada;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.LinearLayout;

public class Tela_casa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_casa);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
        return true;
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
        CardView card_casa = findViewById(R.id.casa_arejada);
        CardView card_sapatos = findViewById(R.id.sapatos);
        CardView card_alimentacao = findViewById(R.id.alimentacao);
        CardView card_roupas = findViewById(R.id.roupas);
        Intent intent_conteudo_cards = new Intent(this,conteudo_cards.class);
        Bundle parametros = new Bundle();
        if (view == card_casa){
            parametros.putString("titulo","Porque deixar a casa arejada?");
            parametros.putInt("conteudo",R.string.conteudo_casa);
            intent_conteudo_cards.putExtras(parametros);
            startActivity(intent_conteudo_cards);
        }else if (view == card_sapatos){
            parametros.putString("titulo","Retire os sapatos ao chegar em casa");
            parametros.putInt("conteudo",R.string.conteudo_sapatos);
            intent_conteudo_cards.putExtras(parametros);
            startActivity(intent_conteudo_cards);
        }else if (view == card_alimentacao){
            parametros.putString("titulo","Tenha uma alimentação saudável");
            parametros.putInt("conteudo",R.string.conteudo_alimentacao);
            intent_conteudo_cards.putExtras(parametros);
            startActivity(intent_conteudo_cards);
        }else if(view == card_roupas){
            parametros.putString("titulo","Lave a roupa usada ao chegar em casa");
            parametros.putInt("conteudo",R.string.conteudo_lavar_roupas);
            intent_conteudo_cards.putExtras(parametros);
            startActivity(intent_conteudo_cards);
        }


    }
}