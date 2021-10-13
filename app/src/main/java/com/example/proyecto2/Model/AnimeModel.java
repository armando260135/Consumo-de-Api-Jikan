package com.example.proyecto2.Model;

import android.content.Context;
import android.widget.Toast;
import com.example.proyecto2.intefaces.AnimeInteractor;
import com.example.proyecto2.intefaces.AnimePresenter;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeModel implements AnimeInteractor{
    private AnimePresenter presenter;
<<<<<<< HEAD
=======
    private static final String TAG="ANIME";
    private static final String TAG2="ANIMETOP";
    private static final String TAG3="ANIMEBEST";
    private Retrofit retrofit;
>>>>>>> origin/master
    private Context context;
    private List<AnimeRespuesta> animeModelLista;

    public AnimeModel(AnimePresenter presenter,Context context) {
        this.presenter = presenter;
        this.context = context;
        this.animeModelLista = new ArrayList<>();
    }

    @Override
<<<<<<< HEAD
    public void obtenerDatosUpComingApi() {
        Call<AnimeRespuesta> call = Conexion.getAnimeService().obtenerListaAnimeUpcoming();
        call.enqueue(new Callback<AnimeRespuesta>() {
            @Override
            public void onResponse(Call<AnimeRespuesta> call, Response<AnimeRespuesta> response) {
                if (response.isSuccessful()){
                    AnimeRespuesta animeRespuesta = response.body();
                    ArrayList<AnimeResults> animeResultsArrayListUpComing = animeRespuesta.getResults();
                    presenter.mostrarDatosUpComing(animeResultsArrayListUpComing);
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
    public void obtenerDatosUpComing() {
        obtenerDatosUpComingApi();
    }

    @Override
=======
>>>>>>> origin/master
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

    @Override
    public void obtenerDatosApiTop() {
        Call<AnimeRespuesta> call = Conexion.getAnimeService().obtenerListaAnimesTop();
        call.enqueue(new Callback<AnimeRespuesta>() {
<<<<<<< HEAD

=======
>>>>>>> origin/master
            @Override
            public void onResponse(Call<AnimeRespuesta> call, Response<AnimeRespuesta> response) {
                if (response.isSuccessful()){
                    AnimeRespuesta animeRespuesta = response.body();
                    ArrayList<AnimeResults> animeResultsArrayListTop = animeRespuesta.getResults();
                    presenter.mostrarDatosTop(animeResultsArrayListTop);
<<<<<<< HEAD
=======
                    for (int i=0;i<animeResultsArrayListTop.size();i++){
                        AnimeResults a = animeResultsArrayListTop.get(i);
                        Log.i(TAG,"ANIMETOP: "+ a.getTitle());

                    }

>>>>>>> origin/master
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
<<<<<<< HEAD
=======

>>>>>>> origin/master
    }

    @Override
    public void obtenerDatosTop() {
        obtenerDatosApiTop();
<<<<<<< HEAD
=======

>>>>>>> origin/master
    }

    @Override
    public void obtenerDatosApiSpecial() {
        Call<AnimeRespuesta> call = Conexion.getAnimeService().obtenerListaAnimesSpecial();
        call.enqueue(new Callback<AnimeRespuesta>() {
            @Override
            public void onResponse(Call<AnimeRespuesta> call, Response<AnimeRespuesta> response) {
                if (response.isSuccessful()){
                    AnimeRespuesta animeRespuesta = response.body();
                    ArrayList<AnimeResults> animeResultsArrayListSpecial = animeRespuesta.getResults();
                    presenter.mostrarDatosSpecial(animeResultsArrayListSpecial);
<<<<<<< HEAD
=======
                    for (int i=0;i<animeResultsArrayListSpecial.size();i++){
                        AnimeResults a = animeResultsArrayListSpecial.get(i);
                        Log.i(TAG3,"ANIMEBEST: "+ a.getTitle());

                    }

>>>>>>> origin/master
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
<<<<<<< HEAD
=======

>>>>>>> origin/master
    }

    @Override
    public void obtenerDatosSpecial() {
        obtenerDatosApiSpecial();
<<<<<<< HEAD
=======

>>>>>>> origin/master
    }
}
