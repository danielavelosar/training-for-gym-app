package com.example.trackingforgym;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    NavController navController;

    LinearLayout contenedorSeekBarRutina;
    RecyclerView recycler;
    Adaptador_rutina_layout adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        confRed();
        //DataBase.addUser("ads","asd","asd");
        new Session();
        if (!Session.getSession()) {
            definirSession();
            System.out.println("paso");
        }



        /*setSupportActionBar(binding.appBarMain.toolbar);

        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        setSupportActionBar(findViewById(R.id.toolbar));
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
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
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        setElements();
        //configurarSpinnerHome();

        setInfNavButtons();
    }

    private void setInfNavButtons(){
        ImageView btnHomeBar = (ImageView) findViewById(R.id.btnHomeBar);
        ImageView btnMenuBar = (ImageView) findViewById(R.id.btnMenuBar);
        ImageView btnStatsBar = (ImageView) findViewById(R.id.btnStatsBar);
        btnHomeBar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                System.out.println("jome");
                navController.navigate(R.id.nav_home);
            }
        });
        btnMenuBar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                System.out.println("ad");
                navController.navigate(R.id.nav_gallery);
            }
        });
        btnStatsBar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                System.out.println("joasd");
                navController.navigate(R.id.nav_slideshow);
            }
        });
        /*binding.appBarMain.btnHomeBar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                System.out.println("jome");
                navController.navigate(R.id.nav_home);
            }
        });
        binding.appBarMain.btnMenuBar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                System.out.println("as");
                navController.navigate(R.id.nav_gallery);
            }
        });
        binding.appBarMain.btnStatsBar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                System.out.println("adf");
                navController.navigate(R.id.nav_slideshow);
            }
        });*/
    }

    private void confRed(){
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    @Override
    protected void onStart(){
        super.onStart();

        System.out.println("de vuelta");

        setRecycler();
    }

    public void setElements(){
        contenedorSeekBarRutina=(LinearLayout) findViewById(R.id.contenerdorSeekBarEntrenamiento);

        setRecycler();
    }

    public void setRecycler(){

        recycler = (RecyclerView) findViewById(R.id.contenedorRutinas);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));

        String[] rutinas={
                "1","2","3","4","5","6","31","14","11","121","131","114"
        };

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
        Toast toast = Toast.makeText(this, str, Toast.LENGTH_SHORT);
        toast.show();
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