package com.example.proyecto2.Model;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.proyecto2.intefaces.AnimeInteractor;
import com.example.proyecto2.intefaces.AnimePresenter;
import com.example.proyecto2.intefaces.AnimeService;
import com.example.proyecto2.intefaces.AnimeView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimeModel implements AnimeInteractor{
    private AnimePresenter presenter;
    private static final String TAG="ANIME";
    private Retrofit retrofit;
    private Context context;
    private List<AnimeRespuesta> animeModelLista;


    public AnimeModel(AnimePresenter presenter,Context context) {
        this.presenter = presenter;
        this.context = context;
        this.animeModelLista = new ArrayList<>();
    }

    @Override
    public void obtenerDatosApi() {

        Call<AnimeRespuesta> call = Conexion.getAnimeService().obtenerListaAnimes();
        call.enqueue(new Callback<AnimeRespuesta>() {
            @Override
            public void onResponse(Call<AnimeRespuesta> call, Response<AnimeRespuesta> response) {
                if (response.isSuccessful()){
                    AnimeRespuesta animeRespuesta = response.body();
                    ArrayList<AnimeResults> animeRespuestaArrayList = animeRespuesta.getResults();
                    presenter.mostrarDatos(animeRespuestaArrayList);

                }else{
                    Toast.makeText(context, "RESPUESTA: " + response.code(), Toast.LENGTH_SHORT).show();
                    return;

                }
            }

            @Override
            public void onFailure(Call<AnimeRespuesta> call, Throwable t) {
                Toast.makeText(context, "error"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void obtenerDatos() {
        obtenerDatosApi();
    }
}
