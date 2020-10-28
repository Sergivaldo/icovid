package com.example.app_olimpiada;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.text.NumberFormat;
public class tela_covid extends AppCompatActivity {
    ArrayList<String> brazil_data = new ArrayList<>();
    ArrayList<String> date_time_updated = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_covid);
        final TextView n_cT = findViewById(R.id.n_confirmados_total);
        final TextView n_oT = findViewById(R.id.n_obitos_total);
        final TextView n_rec = findViewById(R.id.n_recuperados);
        final TextView n_eA = findViewById(R.id.n_acompanhamento);
        final TextView n_cN = findViewById(R.id.n_casos_novos);
        final TextView n_oN = findViewById(R.id.n_obitos_novos);
        final TextView date_time = findViewById(R.id.hora_atualizacao);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference brazil_ref = database.getReference().child("brasil");
        DatabaseReference date_time_updated_ref = database.getReference().child("data_hora_atualizacao");
        DatabaseReference bahia_ref = database.getReference().child("bahia");

        date_time_updated_ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    date_time_updated.add(snapshot.getValue().toString());
                }

                date_time.setText("Última atualização: " + date_time_updated.get(0) + "     " +" Horário: "+ date_time_updated.get(1));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        brazil_ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    brazil_data.add(snapshot.getValue().toString());

                }
                n_cN.setText(NumberFormat.getIntegerInstance().format(Integer.parseInt(brazil_data.get(0))));
                n_cT.setText(NumberFormat.getIntegerInstance().format(Integer.parseInt(brazil_data.get(1))));
                n_eA.setText(NumberFormat.getIntegerInstance().format(Integer.parseInt(brazil_data.get(2))));
                n_oN.setText(NumberFormat.getIntegerInstance().format(Integer.parseInt(brazil_data.get(3))));
                n_oT.setText(NumberFormat.getIntegerInstance().format(Integer.parseInt(brazil_data.get(4))));
                n_rec.setText(NumberFormat.getIntegerInstance().format(Integer.parseInt(brazil_data.get(5))));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
        return true;
    }


    public void set_info(View view) {
        TextView btt_brazil = findViewById(R.id.Brasil);
        TextView btt_bahia = findViewById(R.id.Bahia);

        if (view == btt_bahia){
            btt_bahia.setBackgroundResource(R.color.clicado);
            btt_brazil.setBackgroundResource(R.color.fundo_pais_estado);
        }else{
            btt_bahia.setBackgroundResource(R.color.fundo_pais_estado);
            btt_brazil.setBackgroundResource(R.color.clicado);

        }


    }
}