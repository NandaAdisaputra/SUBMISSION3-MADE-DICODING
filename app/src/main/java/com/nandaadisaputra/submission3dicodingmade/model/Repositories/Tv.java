package com.nandaadisaputra.submission3dicodingmade.model.Repositories;

import androidx.lifecycle.MutableLiveData;

import com.nandaadisaputra.submission3dicodingmade.model.response.TvResponse;
import com.nandaadisaputra.submission3dicodingmade.network.ApiService;
import com.nandaadisaputra.submission3dicodingmade.network.config.Client;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tv {

    private static Tv movieRepository;

    public static Tv getInstance() {
        if (movieRepository == null) {
            movieRepository = new Tv();
        }
        return movieRepository;
    }

    private ApiService apiService;

    public Tv() {
        apiService = Client.getInitRetrofit();
    }

    public MutableLiveData<TvResponse> getTv() {
        final MutableLiveData<TvResponse> tvData = new MutableLiveData<>();
        apiService.getTvData().enqueue(new Callback<TvResponse>() {
            @Override
            public void onResponse(Call<TvResponse> call, Response<TvResponse> response) {
                if ((response.body() != null ? response.body().getPage() : 0) > 0) {
                    tvData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<TvResponse> call, Throwable t) {
                tvData.setValue(null);
            }
        });
        return tvData;
    }
}
