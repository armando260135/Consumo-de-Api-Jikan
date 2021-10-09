package com.example.proyecto2.intefaces;

import com.example.proyecto2.Model.AnimeRespuesta;
import com.example.proyecto2.Model.AnimeResults;

import java.util.ArrayList;

public interface  AnimeView {
    void mostrarDatos(ArrayList<AnimeResults> animeresultadolista);
    void mostrarDatosTop(ArrayList<AnimeResults> animeResultsArrayListTop);
    void mostrarDatosSpecial(ArrayList<AnimeResults> animeResultsArrayListSpecial);


}
