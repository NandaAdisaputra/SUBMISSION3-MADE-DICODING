package com.nandaadisaputra.submission3dicodingmade.activity.detail;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.nandaadisaputra.submission3dicodingmade.BuildConfig;
import com.nandaadisaputra.submission3dicodingmade.R;
import com.nandaadisaputra.submission3dicodingmade.model.results.ResultsMovie;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRAMOVIE = "extra_movie";
    @BindView(R.id.iv_imagemovie)
    ImageView ivImage;
    @BindView(R.id.tv_titlemovie)
    TextView tvDetailJudul;
    @BindView(R.id.tv_genremovie)
    TextView tvDetailGenre;
    @BindView(R.id.tv_release_datemovie)
    TextView tvDetailTanggalRilis;
    @BindView(R.id.tv_descriptionmovie)
    TextView tvDetailDeskripsi;

    private ProgressDialog progressDialog;

    private static final String STATE_RESULT = "state_result";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        ButterKnife.bind(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.show();

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            Glide.with(this).load(result).into(ivImage);
            tvDetailJudul.setText(result);
            tvDetailGenre.setText(result);
            tvDetailTanggalRilis.setText(result);
            tvDetailDeskripsi.setText(result);
            progressDialog.dismiss();
        }

        setUpDelay();


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ResultsMovie resultsItemMovie = getIntent().getParcelableExtra(EXTRAMOVIE);
        outState.putString(STATE_RESULT, resultsItemMovie.getPosterPath());
        outState.putString(STATE_RESULT, resultsItemMovie.getOriginalName());
        outState.putString(STATE_RESULT, String.valueOf(resultsItemMovie.getGenreIds()));
        outState.putString(STATE_RESULT, resultsItemMovie.getFirstAirDate());
        outState.putString(STATE_RESULT, resultsItemMovie.getOverview());

    }

    private void setUpDelay() {
        new Handler().postDelayed(() -> {
            progressDialog.dismiss();
            ResultsMovie resultsItemMovie = getIntent().getParcelableExtra(EXTRAMOVIE);
            getSupportActionBar().setTitle(getString(R.string.moviedetail) + " " + resultsItemMovie.getOriginalName());
            Glide.with(DetailMovieActivity.this).load(BuildConfig.BASE_URL_IMAGE + resultsItemMovie.getBackdropPath()).into(ivImage);
            tvDetailJudul.setText(resultsItemMovie.getOriginalName());
            tvDetailGenre.setText(String.valueOf(resultsItemMovie.getGenreIds()));
            tvDetailTanggalRilis.setText(resultsItemMovie.getFirstAirDate());
            tvDetailDeskripsi.setText(resultsItemMovie.getOverview());
        }, 2000);
    }
}
