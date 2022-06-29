package com.example.trackingforgym.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trackingforgym.R;
import com.example.trackingforgym.data.DataBase;
import com.example.trackingforgym.data.Ejercicio;
import com.example.trackingforgym.data.Rutine;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import sun.bob.mcalendarview.MCalendarView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_creacion_rutina#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_creacion_rutina extends Fragment {
    EditText nombreRutina;
    Button crearRutina;
    FloatingActionButton agregarEjercicio;
    View root;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    public fragment_creacion_rutina() {
        }


    // TODO: Rename and change types and number of parameters
    public static fragment_creacion_rutina newInstance(String param1, String param2) {
        fragment_creacion_rutina fragment = new fragment_creacion_rutina();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_creacion_rutina, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        root = view;
        nombreRutina = (EditText) view.findViewById(R.id.editText_nombre_rutina);
        crearRutina = (Button) view.findViewById(R.id.button_crear);
        agregarEjercicio = (FloatingActionButton)  view.findViewById(R.id.button_agregar_ejercicios);
        crearRutina.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                System.out.println("creo rutina");
                Snackbar.make(view, "rutina creada : "+ nombreRutina.getText().toString(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Ejercicio a = new Ejercicio("curl " +nombreRutina.getText().toString(), "rojo", "bicep");
                a.upload();
                a.setIdDataBase();
                Rutine nuevaRutina = new Rutine("rojo", "kkl" + nombreRutina.getText().toString());
                nuevaRutina.ejercicios.add(a);
                nuevaRutina.upload();
            };});

            agregarEjercicio.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Navigation.findNavController(view).navigate(R.id.fragment_creacion_ejercicio);
                }
            }
        );

    }
        // or  (ImageView) view.findViewById(R.id.foo);
}