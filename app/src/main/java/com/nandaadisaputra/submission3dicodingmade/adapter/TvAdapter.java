package com.nandaadisaputra.submission3dicodingmade.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nandaadisaputra.submission3dicodingmade.BuildConfig;
import com.nandaadisaputra.submission3dicodingmade.R;
import com.nandaadisaputra.submission3dicodingmade.activity.detail.DetailTvActivity;
import com.nandaadisaputra.submission3dicodingmade.model.results.ResultsMovie;

import java.util.List;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.ViewHolder> {

    private Context context;
    private List<ResultsMovie> listitem;


    public TvAdapter(Context context, List<ResultsMovie> resultsItemTv) {
        this.context = context;
        this.listitem = resultsItemTv;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tv, viewGroup, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {


        viewHolder.tvTitle.setText(listitem.get(i).getName());
        viewHolder.tvDateRelease.setText(listitem.get(i).getFirstAirDate());
        viewHolder.tvOverview.setText(listitem.get(i).getOverview());
        viewHolder.tvOriginalLanguage.setText(listitem.get(i).getOriginalLanguage());
        viewHolder.tvPopularity.setText(String.valueOf(listitem.get(i).getPopularity()));
        viewHolder.tvGenre.setText(String.valueOf(listitem.get(i).getGenreIds()));
        viewHolder.tvVote.setText(String.valueOf(listitem.get(i).getVoteAverage()));
        Glide.with(context).load(BuildConfig.BASE_URL_IMAGE + listitem.get(i).getPosterPath()).into(viewHolder.ivPoster);

        viewHolder.btnDetail.setOnClickListener(v -> {
            Intent btn_detailtv = new Intent(context, DetailTvActivity.class);
            btn_detailtv.putExtra(DetailTvActivity.EXTRATVSHOW, listitem.get(i));
            context.startActivity(btn_detailtv);
        });

        viewHolder.btnShare.setOnClickListener(v -> {
            Intent sharingIntent = new Intent(Intent.ACTION_VIEW);
            sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            sharingIntent.setData(Uri.parse("https://web.whatsapp.com/"));
            context.startActivity(sharingIntent);
        });
    }

    @Override
    public int getItemCount() {
        return listitem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle, tvDateRelease, tvVote, tvOverview, tvOriginalLanguage, tvGenre, tvPopularity;
        private ImageView ivPoster;
        private Button btnShare, btnDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_titletv);
            tvDateRelease = itemView.findViewById(R.id.tv_datetv);
            tvVote = itemView.findViewById(R.id.tv_votetv);
            ivPoster = itemView.findViewById(R.id.iv_imgtv);
            tvOverview = itemView.findViewById(R.id.tv_overviewtv);
            tvOriginalLanguage = itemView.findViewById(R.id.tv_originallanguagetv);
            btnDetail = itemView.findViewById(R.id.btn_detailtv);
            btnShare = itemView.findViewById(R.id.btn_sharetv);
            tvGenre = itemView.findViewById(R.id.tv_genretv);
            tvPopularity = itemView.findViewById(R.id.tv_popularitytv);
        }
    }
}

