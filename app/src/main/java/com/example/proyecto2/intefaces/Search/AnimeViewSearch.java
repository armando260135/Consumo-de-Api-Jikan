package com.example.proyecto2.intefaces.Search;

import com.example.proyecto2.Model.AnimeResults;

import java.util.ArrayList;

public interface AnimeViewSearch {
    void mostrarDatosBusquedad(ArrayList<AnimeResults> animeResultsArrayListBusquedad);
    void mostrarProgressBar();
    void ocultarProgressBar();

}
