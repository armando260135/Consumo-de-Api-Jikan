package com.example.proyecto2.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.proyecto2.R;
import com.example.proyecto2.intefaces.AnimePresenter;
import com.example.proyecto2.Model.AnimeResults;
import com.example.proyecto2.intefaces.AnimeView;
import com.example.proyecto2.presenters.AnimePresenterlmp;
import com.example.proyecto2.Adapter.ListaAnimeAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimeView {
    private RecyclerView recyclerView;
    private TextView noInternetTextView,TextViewTodaySelection;
    private AnimePresenter presenter = new AnimePresenterlmp(this, MainActivity.this);
    private ListaAnimeAdapter listaAnimeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        TextViewTodaySelection = findViewById(R.id.TextViewTodaySelection);
        onCreate2();

    }

    public void onCreate2(){
        presenter.obtenerDatos();
    }


    @Override
    public void mostrarDatos(ArrayList<AnimeResults> animeresultadolista) {
        listaAnimeAdapter = new ListaAnimeAdapter(animeresultadolista,this);
        recyclerView.setAdapter(listaAnimeAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    @Override
    public void mostrarTop1() {

    }


}