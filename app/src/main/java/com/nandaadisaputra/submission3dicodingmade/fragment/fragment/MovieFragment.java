package com.nandaadisaputra.submission3dicodingmade.fragment.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nandaadisaputra.submission3dicodingmade.R;
import com.nandaadisaputra.submission3dicodingmade.adapter.MovieAdapter;
import com.nandaadisaputra.submission3dicodingmade.model.results.ResultsMovie;
import com.nandaadisaputra.submission3dicodingmade.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MovieFragment extends Fragment {

    @BindView(R.id.rv_movie)
    RecyclerView rvMovie;
    private MovieAdapter adapterMovie;

    private ArrayList<ResultsMovie> resultsItemMovieArrayList = new ArrayList<>();
    public MainViewModel mainViewModel;

    private ProgressDialog progressDialog;
    private Unbinder unbinder;


    public MovieFragment() {
        /* Required empty public constructor */
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.show();

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.initMovie();
        mainViewModel.getMoviesModel().observe(this, responseMovie -> {
            progressDialog.dismiss();
            List<ResultsMovie> resultsItemMovies = responseMovie.getResults();
            resultsItemMovieArrayList.addAll(resultsItemMovies);
            adapterMovie.notifyDataSetChanged();
        });

        setupRecyclerView();

    }

    private void setupRecyclerView() {
        if (adapterMovie == null) {
            adapterMovie = new MovieAdapter(getActivity(), resultsItemMovieArrayList);
            rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
            rvMovie.setAdapter(adapterMovie);
            rvMovie.setItemAnimator(new DefaultItemAnimator());
            rvMovie.setNestedScrollingEnabled(true);
        } else {
            adapterMovie.notifyDataSetChanged();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
