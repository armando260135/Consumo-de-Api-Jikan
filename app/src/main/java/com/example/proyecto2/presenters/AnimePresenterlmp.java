package com.example.proyecto2.presenters;

import android.content.Context;
import com.example.proyecto2.Model.AnimeModel;
import com.example.proyecto2.Model.AnimeResults;
import com.example.proyecto2.intefaces.AnimeInteractor;
import com.example.proyecto2.intefaces.AnimePresenter;
import com.example.proyecto2.intefaces.AnimeView;
import java.util.ArrayList;

public class AnimePresenterlmp implements AnimePresenter {

    AnimeView view;
    AnimeInteractor animemodel;

    public AnimePresenterlmp(AnimeView view, Context context) {
        this.view = view;
        animemodel = new AnimeModel(this, context);
    }

    @Override
    public void mostrarDatosUpComing(ArrayList<AnimeResults> animeResultsArrayListUpComing) {
        view.mostrarDatosUpComing(animeResultsArrayListUpComing);
    }

    @Override
    public void mostrarDatos(ArrayList<AnimeResults> animeresultadolista) {
        view.mostrarDatos(animeresultadolista);
    }

    @Override
    public void mostrarDatosTop(ArrayList<AnimeResults> animeResultsArrayListTop) {
        view.mostrarDatosTop(animeResultsArrayListTop);
    }

    @Override
    public void mostrarDatosSpecial(ArrayList<AnimeResults> animeResultsArrayListSpecial) {
        view.mostrarDatosSpecial(animeResultsArrayListSpecial);
    }

    @Override
    public void obtenerDatosUpComing() {
        animemodel.obtenerDatosUpComing();
    }

    @Override
    public void obtenerDatos() {
        animemodel.obtenerDatos();
    }

    @Override
    public void obtenerDatosTop() {
        animemodel.obtenerDatosTop();
    }

    @Override
    public void obtenerDatosSpecial() {
        animemodel.obtenerDatosSpecial();
    }
}
