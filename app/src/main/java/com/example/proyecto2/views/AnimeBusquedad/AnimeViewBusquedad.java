package com.example.proyecto2.views.AnimeBusquedad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.proyecto2.Adapter.ListaAnimeAdapterBusquedad;
import com.example.proyecto2.Model.AnimeResults;
import com.example.proyecto2.R;
import com.example.proyecto2.intefaces.Search.AnimePresenterSearch;
import com.example.proyecto2.intefaces.Search.AnimeViewSearch;
import com.example.proyecto2.presenters.SearchP.AnimePresenterlmpSearch;
import com.example.proyecto2.views.Fragment.CuartoFragment;
import com.example.proyecto2.views.Fragment.TercerFragment;
import com.example.proyecto2.views.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class AnimeViewBusquedad extends AppCompatActivity implements AnimeViewSearch {
    private EditText editTextCogerPlabra;
    private ImageButton iconoBuscar;
    private RecyclerView recyclerBusqueda;
    private ListaAnimeAdapterBusquedad listaAnimeAdapterBusquedad;
    private AnimePresenterSearch presenterSearch = new AnimePresenterlmpSearch(this, AnimeViewBusquedad.this);
    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton myFab;
    private String lenovo = "";
    private ProgressBar progressBar;

    TercerFragment miTv = new TercerFragment();
    CuartoFragment miSetting = new CuartoFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_view_busquedad);
        editTextCogerPlabra = findViewById(R.id.animeText);
        iconoBuscar = findViewById(R.id.BottomBuscador);
        recyclerBusqueda = findViewById(R.id.recyclerViewBusquedad);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        myFab = findViewById(R.id.fab);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        myFab.setColorFilter(android.R.color.white);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).isEnabled();
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        recyclerBusqueda.setVisibility(View.VISIBLE);
        iconoBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lenovo = editTextCogerPlabra.getText().toString();
                mostrarProgressBar();
                recyclerBusqueda.setVisibility(View.INVISIBLE);
                presenterSearch.obtenerDatosBusquedad(lenovo);
            }
        });
        onCreate3();
    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }

    public void onCreate3() {
        ocultarProgressBar();
        presenterSearch.obtenerDatosBusquedad(lenovo);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.miHome:
                    // loadFragment(miHome);
                    Intent i = new Intent(AnimeViewBusquedad.this, MainActivity.class);
                    startActivity(i);
                    finish();
                    return true;
                case R.id.miSearch:
//                    loadFragment(miSearch);
                    Intent irsearch2 = new Intent(AnimeViewBusquedad.this, AnimeViewBusquedad.class);
                    startActivity(irsearch2);
                    onBackPressed();
                    return true;
                case R.id.miTv:
                    loadFragment(miTv);
//                    Intent irtv = new Intent(MainActivity.this, AnimeTv.class);
//                    startActivity(irtv);
//                    finish();
                    return true;
                case R.id.miSetting:
                    loadFragment(miSetting);
//                    Intent irconfig = new Intent(MainActivity.this, AnimeDemoDetalle.class);
//                    startActivity(irconfig);
//                    finish();
                    return true;
            }
            return false;
        }
    };

    @Override
    public void mostrarDatosBusquedad(ArrayList<AnimeResults> animeResultsArrayListBusquedad) {
        ocultarProgressBar();
        recyclerBusqueda.setVisibility(View.VISIBLE);
        //recycler view Busquedad
        listaAnimeAdapterBusquedad = new ListaAnimeAdapterBusquedad(animeResultsArrayListBusquedad, this);
        recyclerBusqueda.setAdapter(listaAnimeAdapterBusquedad);
        recyclerBusqueda.setHasFixedSize(true);
        GridLayoutManager layoutManager3 = new GridLayoutManager(this, 3);
        recyclerBusqueda.setLayoutManager(layoutManager3);
    }

    @Override
    public void mostrarProgressBar() {
        runOnUiThread(() -> {
            progressBar.setVisibility(View.VISIBLE);
        });
    }

    @Override
    public void ocultarProgressBar() {
        runOnUiThread(() -> {
            progressBar.setVisibility(View.GONE);
        });
    }
}