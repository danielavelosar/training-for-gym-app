package com.example.trackingforgym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.EventLogTags;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class registro_por_rutina extends AppCompatActivity {

    List<Lista_Rutinas> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_por_rutina);

        init();
    }

    public void init(){
        elements = new ArrayList<>();
        elements.add(new Lista_Rutinas("#FF2D00", "Flexiones con palmada", "Tren superior", "Fuerte"));
        elements.add(new Lista_Rutinas("#0008FF", "Press con mancuernas", "Tren superior", "Fuerte"));
        elements.add(new Lista_Rutinas("#59FF00", "Tríceps con mancuerna", "Tren superior", "Fuerte"));
        elements.add(new Lista_Rutinas("#008FFF", "Curl de bíceps con mancuernas", "Tren superior", "Fuerte"));
        elements.add(new Lista_Rutinas("#F000FF", "Elevaciones frontales con mancuernas", "Tren superior", "Fuerte"));

        Rutinas_Adaptador rutinas_adaptador = new Rutinas_Adaptador(elements, this, new Rutinas_Adaptador.OnItemClickListener() {
            @Override
            public void onItemClick(Lista_Rutinas item) {
                moveToDescription(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.recycler_rutinas);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(rutinas_adaptador);

    }

    public void moveToDescription(Lista_Rutinas item){
        Intent intent = new Intent(this, DescriptionActivity.class);
        intent.putExtra("Lista_Rutinas",item);
        startActivity(intent);
    }
}