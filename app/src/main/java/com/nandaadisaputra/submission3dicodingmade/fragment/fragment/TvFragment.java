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
import com.nandaadisaputra.submission3dicodingmade.adapter.TvAdapter;
import com.nandaadisaputra.submission3dicodingmade.model.results.ResultsMovie;
import com.nandaadisaputra.submission3dicodingmade.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class TvFragment extends Fragment {

    @BindView(R.id.rvTv)
    RecyclerView rvMovie;
    private TvAdapter adapterTv;

    private ArrayList<ResultsMovie> resultsItemTvArrayList = new ArrayList<>();
    public MainViewModel mainViewModel;

    private ProgressDialog progressDialog;
    private Unbinder unbinder;


    public TvFragment() {
        /* Required empty public constructor */
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv, container, false);
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
        mainViewModel.initTv();
        mainViewModel.getTvModel().observe(this, responseTvShow -> {
            progressDialog.dismiss();
            List<ResultsMovie> resultsItemTv = responseTvShow.getResults();
            resultsItemTvArrayList.addAll(resultsItemTv);
            adapterTv.notifyDataSetChanged();
        });

        setupRecyclerView();

    }

    private void setupRecyclerView() {
        if (adapterTv == null) {
            adapterTv = new TvAdapter(getActivity(), resultsItemTvArrayList);
            rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
            rvMovie.setAdapter(adapterTv);
            rvMovie.setItemAnimator(new DefaultItemAnimator());
            rvMovie.setNestedScrollingEnabled(true);
        } else {
            adapterTv.notifyDataSetChanged();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
