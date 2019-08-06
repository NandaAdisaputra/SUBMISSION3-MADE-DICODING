package com.nandaadisaputra.submission3dicodingmade.network;

import com.nandaadisaputra.submission3dicodingmade.BuildConfig;
import com.nandaadisaputra.submission3dicodingmade.model.response.MovieResponse;
import com.nandaadisaputra.submission3dicodingmade.model.response.TvResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("discover/movie?api_key=" + BuildConfig.API_KEY + "&language=en-US")
    Call<MovieResponse> getDataMovie();

    @GET("discover/tv?api_key=" + BuildConfig.API_KEY + "&language=en-US")
    Call<TvResponse> getTvData();
}
