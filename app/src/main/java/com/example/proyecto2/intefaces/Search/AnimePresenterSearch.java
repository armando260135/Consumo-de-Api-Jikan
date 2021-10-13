package com.example.proyecto2.intefaces.Search;

import com.example.proyecto2.Model.AnimeResults;

import java.util.ArrayList;

public interface AnimePresenterSearch {
    void mostrarDatosBusquedad(ArrayList<AnimeResults> animeResultsArrayListBusquedad);
    void obtenerDatosBusquedad(String obtenido);
    void mostrarMensajeError();
}
