package com.example.proyecto2.intefaces;

import com.example.proyecto2.Model.AnimeRespuesta;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimeService {

    //slider inicio
    @GET("search/anime?q=type=upcoming")
    Call <AnimeRespuesta> obtenerListaAnimeUpcoming();

    //original top 10 today selection
    @GET("search/anime?q=&order_by=members&sort=desc&page=1&limit=10")
    Call <AnimeRespuesta> obtenerListaAnimes();

    //el mejor votado score
    @GET("search/anime?q=5114/Fullmetal_Alchemist__Brotherhood&limit=1")
    Call <AnimeRespuesta> obtenerListaAnimesTop();

    //genero 3 carros
    @GET("search/anime?q=genre/3/Cars")
    Call <AnimeRespuesta> obtenerListaAnimesSpecial();
}
