package com.nandaadisaputra.submission3dicodingmade.model.Repositories;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.nandaadisaputra.submission3dicodingmade.model.response.MovieResponse;
import com.nandaadisaputra.submission3dicodingmade.network.ApiService;
import com.nandaadisaputra.submission3dicodingmade.network.config.Client;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Movie {

    @SuppressLint("all")
    private static Movie movieRepository;
    @SuppressLint("all")
    private static Context context;

    public static Movie getInstance() {
        if (movieRepository == null) {
            movieRepository = new Movie(context);
        }
        return movieRepository;
    }

    private ApiService apiService;

    public Movie(Context context) {
        Movie.context = context;
        apiService = Client.getInitRetrofit();
    }

    public MutableLiveData<MovieResponse> getMovie() {
        final MutableLiveData<MovieResponse> moviData = new MutableLiveData<>();
        apiService.getDataMovie().enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if ((response.body() != null ? response.body().getPage() : 0) > 0) {
                    moviData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                moviData.setValue(null);
            }
        });
        return moviData;
    }
}

