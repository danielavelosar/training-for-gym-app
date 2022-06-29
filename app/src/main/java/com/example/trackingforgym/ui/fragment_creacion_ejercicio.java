package com.example.trackingforgym.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.trackingforgym.R;
import com.example.trackingforgym.data.Ejercicio;
import com.example.trackingforgym.data.Rutine;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_creacion_ejercicio#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_creacion_ejercicio extends Fragment {
    EditText nombreEjercicio;
    Button crearEjercicio;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_creacion_ejercicio() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_creacion_ejercicio.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_creacion_ejercicio newInstance(String param1, String param2) {
        fragment_creacion_ejercicio fragment = new fragment_creacion_ejercicio();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_creacion_ejercicio, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nombreEjercicio = (EditText) view.findViewById(R.id.registro_nombre3);
        crearEjercicio = (Button) view.findViewById(R.id.button_crear_ejercicio);
        crearEjercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("creo rutina");
                Snackbar.make(view, "ejercicio  creado : " + nombreEjercicio.getText().toString(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Ejercicio a = new Ejercicio("curl " + nombreEjercicio.getText().toString(), "azul", "bicep");
                a.upload();
                a.setIdDataBase();
            }

            ;
        });
    }
}