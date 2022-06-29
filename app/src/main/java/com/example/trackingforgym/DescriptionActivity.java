package com.example.trackingforgym;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.trackingforgym.data.Ejercicio;

public class DescriptionActivity extends AppCompatActivity {

    TextView titleDescriptionTextView;
    TextView cityDescriptionTextView;
    TextView statusDescriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Ejercicio element = (Ejercicio) getIntent().getSerializableExtra("Lista_Rutinas");
        titleDescriptionTextView = findViewById(R.id.titleDescriptionTextView);
        cityDescriptionTextView = findViewById(R.id.cityDescriptionTextView);
        statusDescriptionTextView = findViewById(R.id.statusDescriptionTextView);

        titleDescriptionTextView.setText(element.getNombre());
        titleDescriptionTextView.setTextColor(Color.parseColor(element.getColor()));

        cityDescriptionTextView.setText(element.getNombre());

        statusDescriptionTextView.setText(element.getParteCuerpo());
        statusDescriptionTextView.setTextColor(Color.GRAY);
    }
}