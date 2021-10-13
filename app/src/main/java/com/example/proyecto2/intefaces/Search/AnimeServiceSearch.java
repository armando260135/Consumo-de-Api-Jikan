package com.example.proyecto2.intefaces.Search;

import com.example.proyecto2.Model.AnimeRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AnimeServiceSearch {
    //buscar
    @GET("search/anime?q=")
    Call<AnimeRespuesta> obtenerListaAnimeBuscar2(@Query("q") String q);
}
