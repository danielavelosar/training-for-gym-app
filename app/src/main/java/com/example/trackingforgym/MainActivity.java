package com.example.trackingforgym;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trackingforgym.data.Session;
import com.example.trackingforgym.databinding.ActivityMainBinding;
import com.example.trackingforgym.ui.Adaptador_rutina_layout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    LinearLayout contenedorSeekBarRutina;
    RecyclerView recycler;
    Adaptador_rutina_layout adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        //DataBase.addUser("ads","asd","asd");
        new Session();
        if (!Session.getSession()) {
            definirSession();
            System.out.println("paso");
        }

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        setElements();
        //configurarSpinnerHome();

    }

    public void setElements(){
        contenedorSeekBarRutina=(LinearLayout) findViewById(R.id.contenerdorSeekBarEntrenamiento);

        setRecycler();
    }

    public void setRecycler(){

        recycler = (RecyclerView) findViewById(R.id.contenedorRutinas);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));

        String[] rutinas={
                "1","2","3","4","1","2","3","4","1","2","3","4"
        };

        adapter=new Adaptador_rutina_layout(rutinas);
        recycler.setAdapter(adapter);

    }

    /*public  void  configurarSpinnerHome(){
        Spinner spinner =(Spinner) findViewById(R.id.spinner);
        String[] textoSpinner ={"intenso","moderado","suave"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, textoSpinner));
    }*/

    public void hideShowSeekBar(View view){
        System.out.println("oprimido");
        if(contenedorSeekBarRutina.getVisibility()==View.VISIBLE)
            contenedorSeekBarRutina.setVisibility(View.GONE);
        else
            contenedorSeekBarRutina.setVisibility(View.VISIBLE);
    }

    public void definirSession(){
        System.out.println("abriendo login");
        Intent abrirLogin = new Intent(MainActivity.this, login.class);
        startActivity(abrirLogin);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}