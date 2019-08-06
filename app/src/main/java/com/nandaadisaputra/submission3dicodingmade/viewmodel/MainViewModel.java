package com.nandaadisaputra.submission3dicodingmade.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nandaadisaputra.submission3dicodingmade.model.Repositories.Movie;
import com.nandaadisaputra.submission3dicodingmade.model.Repositories.Tv;
import com.nandaadisaputra.submission3dicodingmade.model.response.MovieResponse;
import com.nandaadisaputra.submission3dicodingmade.model.response.TvResponse;

public class MainViewModel extends ViewModel {

    private MutableLiveData<MovieResponse> responseMovieMutableLiveData;
    private Movie movie;

    public void initMovie() {
        if (responseMovieMutableLiveData != null) {
            return;
        }
        movie = Movie.getInstance();
        responseMovieMutableLiveData = movie.getMovie();
    }

    public LiveData<MovieResponse> getMoviesModel() {
        return responseMovieMutableLiveData;
    }

    private MutableLiveData<TvResponse> responseTvMutableLiveData;
    private Tv tv;

    public void initTv() {
        if (responseTvMutableLiveData != null) {
            return;
        }
        tv = Tv.getInstance();
        responseTvMutableLiveData = tv.getTv();
    }

    public LiveData<TvResponse> getTvModel() {
        return responseTvMutableLiveData;
    }
}
