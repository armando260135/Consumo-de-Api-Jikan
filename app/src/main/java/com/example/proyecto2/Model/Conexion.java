package com.example.proyecto2.Model;

import com.example.proyecto2.intefaces.AnimeService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Conexion {

    private static AnimeService animeService;

    public static AnimeService getAnimeService(){
        if (animeService==null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.jikan.moe/v3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            animeService= retrofit.create(AnimeService.class);
        }
        return animeService;
    }

}
