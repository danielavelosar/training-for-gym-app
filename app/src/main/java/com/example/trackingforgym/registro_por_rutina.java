package com.example.trackingforgym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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
        elements.add(new Lista_Rutinas("#775447", "Pedro", "Mexico", "Activo"));
        elements.add(new Lista_Rutinas("#775447", "Pedro", "Mexico", "Activo"));
        elements.add(new Lista_Rutinas("#775447", "Pedro", "Mexico", "Activo"));
        elements.add(new Lista_Rutinas("#775447", "Pedro", "Mexico", "Activo"));
        elements.add(new Lista_Rutinas("#775447", "Pedro", "Mexico", "Activo"));

        Rutinas_Adaptador rutinas_adaptador = new Rutinas_Adaptador(elements,this);
        RecyclerView recyclerView = findViewById(R.id.recycler_rutinas);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(rutinas_adaptador);

    }
}