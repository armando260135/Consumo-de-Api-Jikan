package com.example.proyecto2.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.TextView;

import com.example.proyecto2.Adapter.ListaAnimeAdapterBest;
import com.example.proyecto2.R;
import com.example.proyecto2.intefaces.AnimePresenter;
import com.example.proyecto2.Model.AnimeResults;
import com.example.proyecto2.intefaces.AnimeView;
import com.example.proyecto2.presenters.AnimePresenterlmp;
import com.example.proyecto2.Adapter.ListaAnimeAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimeView {
    private RecyclerView recyclerView,recylverviewscroll;
    private TextView noInternetTextView,TextViewTodaySelection;
    private AnimePresenter presenter = new AnimePresenterlmp(this, MainActivity.this);
    private ListaAnimeAdapter listaAnimeAdapter;
    private ListaAnimeAdapterBest listaAnimeAdapterBest;
    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton myFab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recylverviewscroll = findViewById(R.id.recyclerViewScroll);
        TextViewTodaySelection = findViewById(R.id.TextViewTodaySelection);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        myFab =findViewById(R.id.fab);
//        bottomNavigationView.getMenu().getItem(2).isEnabled();
        onCreate2();

    }

    public void onCreate2(){
        presenter.obtenerDatos();
    }


    @Override
    public void mostrarDatos(ArrayList<AnimeResults> animeresultadolista) {
        //recicler view 1 today selection
        listaAnimeAdapter = new ListaAnimeAdapter(animeresultadolista,this);
        recyclerView.setAdapter(listaAnimeAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        //recycler view best rated
        listaAnimeAdapterBest = new ListaAnimeAdapterBest(animeresultadolista,this);
        recylverviewscroll.setAdapter(listaAnimeAdapterBest);
        recylverviewscroll.setHasFixedSize(true);
        GridLayoutManager layoutManager2 = new GridLayoutManager(this,3);
        recylverviewscroll.setLayoutManager(layoutManager2);

        //menu
        myFab.setColorFilter(android.R.color.white);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).isEnabled();
    }

    @Override
    public void mostrarTop1() {

    }


}