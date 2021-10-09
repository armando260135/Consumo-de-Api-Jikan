package com.example.proyecto2.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.proyecto2.Adapter.ListaAnimeAdapterAutorDetalle;
import com.example.proyecto2.Adapter.ListaAnimeAdapterBest;
import com.example.proyecto2.Adapter.ListaAnimeAdapterSliderInicio;
import com.example.proyecto2.Adapter.ListaAnimeAdapterTop;
import com.example.proyecto2.Prueba;
import com.example.proyecto2.R;
import com.example.proyecto2.intefaces.AnimePresenter;
import com.example.proyecto2.Model.AnimeResults;
import com.example.proyecto2.intefaces.AnimeView;
import com.example.proyecto2.presenters.AnimePresenterlmp;
import com.example.proyecto2.Adapter.ListaAnimeAdapter;
import com.example.proyecto2.views.Fragment.CuartoFragment;
import com.example.proyecto2.views.Fragment.PrimerFragment;
import com.example.proyecto2.views.Fragment.SegundoFragment;
import com.example.proyecto2.views.Fragment.TercerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimeView {
    private RecyclerView recyclerView, recylverviewscroll, recyclerViewTop, recyclerViewSliderInicio,recyclerViewAutor;
    private TextView noInternetTextView, TextViewTodaySelection;
    private AnimePresenter presenter = new AnimePresenterlmp(this, MainActivity.this);
    private ListaAnimeAdapter listaAnimeAdapter;
    private ListaAnimeAdapterBest listaAnimeAdapterBest;
    private ListaAnimeAdapterTop listaAnimeAdapterTop;
    private ListaAnimeAdapterSliderInicio listaAnimeAdapterSliderInicio;
    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton myFab;

    PrimerFragment miHome = new PrimerFragment();
    SegundoFragment miSearch = new SegundoFragment();
    TercerFragment miTv = new TercerFragment();
    CuartoFragment miSetting = new CuartoFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recylverviewscroll = findViewById(R.id.recyclerViewScroll);
        recyclerViewTop = findViewById(R.id.recyclerViewTop);
        recyclerViewSliderInicio = findViewById(R.id.recyclerViewSliderInicio);
//        recyclerViewAutor = findViewById(R.id.recyclerViewAutor);
        TextViewTodaySelection = findViewById(R.id.TextViewTodaySelection);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        myFab = findViewById(R.id.fab);
//      bottomNavigationView.getMenu().getItem(2).isEnabled();
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        loadFragment(miHome);
        onCreate2();
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.miHome:
                    // loadFragment(miHome);
                    Intent i = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                    return true;
                case R.id.miSearch:
                    loadFragment(miSearch);
//                    Intent irsearch = new Intent(MainActivity.this, Animesearch.class);
//                    startActivity(irsearch);
//                    finish();
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

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }

    public void onCreate2() {
        presenter.obtenerDatos();
        presenter.obtenerDatosTop();
        presenter.obtenerDatosSpecial();
    }

    @Override
    public void mostrarDatos(ArrayList<AnimeResults> animeresultadolista) {
        //recicler view 1 today selection
        listaAnimeAdapter = new ListaAnimeAdapter(animeresultadolista, this);
        recyclerView.setAdapter(listaAnimeAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        //recycler view slider principal
        listaAnimeAdapterSliderInicio = new ListaAnimeAdapterSliderInicio(animeresultadolista, this);
        recyclerViewSliderInicio.setAdapter(listaAnimeAdapterSliderInicio);
        recyclerViewSliderInicio.setHasFixedSize(true);
        GridLayoutManager layoutManager3 = new GridLayoutManager(this, 1);
        recyclerViewSliderInicio.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        //menu
        myFab.setColorFilter(android.R.color.white);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).isEnabled();
    }

    @Override
    public void mostrarDatosTop(ArrayList<AnimeResults> animeResultsArrayListTop) {
        listaAnimeAdapterTop = new ListaAnimeAdapterTop(animeResultsArrayListTop, this);
        recyclerViewTop.setAdapter(listaAnimeAdapterTop);
        recyclerViewTop.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerViewTop.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }

    @Override
    public void mostrarDatosSpecial(ArrayList<AnimeResults> animeResultsArrayListSpecial) {
        //recycler view best rated
        listaAnimeAdapterBest = new ListaAnimeAdapterBest(animeResultsArrayListSpecial, this);
        recylverviewscroll.setAdapter(listaAnimeAdapterBest);
        recylverviewscroll.setHasFixedSize(true);
        GridLayoutManager layoutManager2 = new GridLayoutManager(this, 3);
        recylverviewscroll.setLayoutManager(layoutManager2);

    }


}