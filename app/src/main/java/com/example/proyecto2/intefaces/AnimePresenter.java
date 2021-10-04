package com.example.proyecto2.intefaces;

import com.example.proyecto2.Model.AnimeRespuesta;
import com.example.proyecto2.Model.AnimeResults;

import java.util.ArrayList;

public interface AnimePresenter {
    void mostrarDatos(ArrayList<AnimeResults> animeresultadolista);
   // void operacionInvalida();
    void obtenerDatos();
    void mostrarTop1();

}
