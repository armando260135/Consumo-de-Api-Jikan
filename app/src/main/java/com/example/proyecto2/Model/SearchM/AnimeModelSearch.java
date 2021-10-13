package com.example.proyecto2.Model.SearchM;

import android.content.Context;
import android.widget.Toast;
import com.example.proyecto2.Model.AnimeRespuesta;
import com.example.proyecto2.Model.AnimeResults;
import com.example.proyecto2.Model.Conexion;
import com.example.proyecto2.intefaces.Search.AnimeInteractorSearch;
import com.example.proyecto2.intefaces.Search.AnimePresenterSearch;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeModelSearch implements AnimeInteractorSearch {
    private AnimePresenterSearch presenterSearch;
    private Context context;
    private List<AnimeRespuesta> animeModelLista;
    
    public AnimeModelSearch(AnimePresenterSearch presenterSearch,Context context) {
            this.presenterSearch = presenterSearch;
            this.context = context;
            this.animeModelLista = new ArrayList<>(); 
    }

    @Override
    public void obtenerDatosBusquedadApi(String obtenido) {
//        Call<AnimeRespuesta> call = ConexionSearch.getAnimeServiceSearch().obtenerListaAnimeBuscar2(obtenido);
        Call<AnimeRespuesta> call = Conexion.getAnimeServiceSearch().obtenerListaAnimeBuscar2(obtenido);
        call.enqueue(new Callback<AnimeRespuesta>() {
            
            @Override
            public void onResponse(Call<AnimeRespuesta> call, Response<AnimeRespuesta> response) {
                if (response.isSuccessful()){
                    AnimeRespuesta animeRespuesta = response.body();
                    if (animeRespuesta !=null ) {
                        ArrayList<AnimeResults> animeResultsArrayListBusquedad = animeRespuesta.getResults();
                        presenterSearch.mostrarDatosBusquedad(animeResultsArrayListBusquedad);
                    }else{
                        presenterSearch.mostrarMensajeError();
                        Toast.makeText(context, "Entre Aqui", Toast.LENGTH_SHORT).show();
                    }
                }else{
//                    Toast.makeText(context, "RESPUESTA: " + response.code(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(context, "Ha ocurrido un error inesperado", Toast.LENGTH_SHORT).show();
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
    public void obtenerDatosBusquedad(String obtenido) {
        obtenerDatosBusquedadApi(obtenido);

    }
}
