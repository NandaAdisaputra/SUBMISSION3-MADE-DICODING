package com.nandaadisaputra.submission3dicodingmade.network.config;

import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.nandaadisaputra.submission3dicodingmade.BuildConfig;
import com.nandaadisaputra.submission3dicodingmade.network.ApiService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static retrofit2.Retrofit.*;

public class Client {
    private static final String BASE_URL = BuildConfig.BASE_URL_MOVIE;

    private static Retrofit getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        return new Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
    public static ApiService getInitRetrofit() {
        return getClient().create(ApiService.class);
    }


}