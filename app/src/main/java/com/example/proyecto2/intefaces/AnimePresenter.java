package com.example.proyecto2.intefaces;

import com.example.proyecto2.Model.AnimeResults;
import java.util.ArrayList;

public interface AnimePresenter {
    void mostrarDatosUpComing(ArrayList<AnimeResults> animeResultsArrayListUpComing);
    void mostrarDatos(ArrayList<AnimeResults> animeresultadolista);
    void mostrarDatosTop(ArrayList<AnimeResults> animeResultsArrayListTop);
    void mostrarDatosSpecial(ArrayList<AnimeResults> animeResultsArrayListSpecial);
    //para upcoming
    void obtenerDatosUpComing();
    //para today
    void obtenerDatos();
    //para Best Anime
    void obtenerDatosTop();
    //para special
    void obtenerDatosSpecial();
}
