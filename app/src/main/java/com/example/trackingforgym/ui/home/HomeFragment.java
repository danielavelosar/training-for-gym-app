package com.example.trackingforgym.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trackingforgym.R;
import com.example.trackingforgym.data.Rutine;
import com.example.trackingforgym.databinding.FragmentHomeBinding;
import com.example.trackingforgym.ui.Adaptador_rutina_layout;

import java.util.Random;
import java.util.Date;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    RecyclerView recycler;
    Adaptador_rutina_layout adapter;
    View root;
    LinearLayout contenedorSeekBarRutina;
    Button btnComoEstuboHoy;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        root = binding.getRoot();
        setElements();

        //final TextView textView = binding.textHome;
        /*homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        return root;
    }
    public void setElements(){
        contenedorSeekBarRutina=(LinearLayout) root.findViewById(R.id.contenerdorSeekBarEntrenamiento);
        btnComoEstuboHoy=root.findViewById(R.id.btnComoEstuboHoy);
        btnComoEstuboHoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideShowSeekBar(view);
            }
        });
        setRecycler();
    }

    public void hideShowSeekBar(View view){
        System.out.println("oprimido");
        if(contenedorSeekBarRutina.getVisibility()==View.VISIBLE)
            contenedorSeekBarRutina.setVisibility(View.GONE);
        else
            contenedorSeekBarRutina.setVisibility(View.VISIBLE);
    }

    public Rutine[] heapSort(Rutine[] arr){
        buildMaxHeap(arr);
        int heapSize = arr.length - 1;
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, heapSize);
            heapSize--;
            maxHeapify(arr, 0, heapSize);
        }
        return(arr);
    }
    public static  void maxHeapify(Rutine[] arr, int i, int n) {
        int leftChild = i * 2 + 1;
        int rightChild = leftChild + 1;
        int largest = i;
        if (leftChild <= n &&  arr[leftChild].mayorQue(arr[i])){
            largest = leftChild;
        }
        if (rightChild <= n && arr[rightChild].mayorQue(arr[largest])) {
            largest = rightChild;
        }
        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest, n);
        }
    }
    public static  void buildMaxHeap(Rutine[] arr) {
        for (int i = arr.length / 2; i > -1; i--) {
            maxHeapify(arr, i, arr.length - 1);
        }
    }
    public static  void swap(Rutine[] arr, int i, int j) {
        Rutine temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void setRecycler(){

        recycler = (RecyclerView) root.findViewById(R.id.contenedorRutinas);
        recycler.setLayoutManager(new LinearLayoutManager(root.getContext(),LinearLayoutManager.HORIZONTAL, true));

        /*String[] rutinas={
                "1","2","3","4","5","6","31","14","11","121","131","114"
        };*/
        Rutine[] rutinas= {
                new Rutine("#E91E63", "Pierna", 1),
                new Rutine("#F44336", "tren Sup",8),
                new Rutine("#03A9F4", "tren inf",50),
                new Rutine("#009688", "Pecho y tricep",2),
                new Rutine("#673AB7", "Gluteo",6)
        };

        rutinas = heapSort(rutinas);

        adapter=new Adaptador_rutina_layout(rutinas);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirRutinaEspecifica(adapter.getDatos(recycler.getChildAdapterPosition(view)));
            }
        });
        recycler.setAdapter(adapter);
    }

    public void abrirRutinaEspecifica(String str){
        System.out.println(str);
        Toast toast = Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}