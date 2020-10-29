package com.example.app_olimpiada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.LinearLayout;

public class Tela_escola extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_escola);
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
}