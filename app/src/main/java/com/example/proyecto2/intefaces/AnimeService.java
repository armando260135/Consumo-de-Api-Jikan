package com.example.proyecto2.intefaces;

import com.example.proyecto2.Model.AnimeRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimeService {
    @GET("search/anime?q=&order_by=members&sort=desc&page=1&limit=10")
    Call <AnimeRespuesta> obtenerListaAnimes();

}
