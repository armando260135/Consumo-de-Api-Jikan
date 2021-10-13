package com.example.proyecto2.presenters.SearchP;

import android.content.Context;

import com.example.proyecto2.Model.AnimeModel;
import com.example.proyecto2.Model.AnimeResults;
import com.example.proyecto2.Model.SearchM.AnimeModelSearch;
import com.example.proyecto2.intefaces.AnimeInteractor;
import com.example.proyecto2.intefaces.AnimeView;
import com.example.proyecto2.intefaces.Search.AnimeInteractorSearch;
import com.example.proyecto2.intefaces.Search.AnimePresenterSearch;
import com.example.proyecto2.intefaces.Search.AnimeViewSearch;

import java.util.ArrayList;

public class AnimePresenterlmpSearch implements AnimePresenterSearch {
    AnimeViewSearch view;
    AnimeInteractorSearch animemodel;

    public AnimePresenterlmpSearch(AnimeViewSearch view, Context context) {
        this.view = view;
        animemodel = new AnimeModelSearch(this,context);
    }
    @Override
    public void mostrarDatosBusquedad(ArrayList<AnimeResults> animeResultsArrayListBusquedad) {
        view.mostrarDatosBusquedad(animeResultsArrayListBusquedad);
    }

    @Override
    public void obtenerDatosBusquedad(String obtenido) {
        animemodel.obtenerDatosBusquedad(obtenido);
    }

    @Override
    public void mostrarMensajeError() {

    }
}
