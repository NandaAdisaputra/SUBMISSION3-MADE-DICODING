package com.nandaadisaputra.submission3dicodingmade.model.results;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResultsMovie implements Parcelable {

    @SerializedName("first_air_date")
    private String firstAirDate;

    @SerializedName("overview")
    private String overview;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("genre_ids")
    private List<Integer> genreIds;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("origin_country")
    private List<String> originCountry;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("original_name")
    private String originalName;

    @SerializedName("popularity")
    private String popularity;

    @SerializedName("vote_average")
    private double voteAverage;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    @SerializedName("vote_count")
    private int voteCount;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstAirDate);
        dest.writeString(this.overview);
        dest.writeString(this.originalLanguage);
        dest.writeList(this.genreIds);
        dest.writeString(this.posterPath);
        dest.writeStringList(this.originCountry);
        dest.writeString(this.backdropPath);
        dest.writeString(this.originalName);
        dest.writeString(this.popularity);
        dest.writeDouble(this.voteAverage);
        dest.writeString(this.name);
        dest.writeInt(this.id);
        dest.writeInt(this.voteCount);
    }

    public ResultsMovie(Parcel in) {
        this.firstAirDate = in.readString();
        this.overview = in.readString();
        this.originalLanguage = in.readString();
        this.genreIds = new ArrayList<>();
        in.readList(this.genreIds, Integer.class.getClassLoader());
        this.posterPath = in.readString();
        this.originCountry = in.createStringArrayList();
        this.backdropPath = in.readString();
        this.originalName = in.readString();
        this.popularity = in.readString();
        this.voteAverage = in.readDouble();
        this.name = in.readString();
        this.id = in.readInt();
        this.voteCount = in.readInt();
    }

    public static final Creator<ResultsMovie> CREATOR = new Creator<ResultsMovie>() {
        @Override
        public ResultsMovie createFromParcel(Parcel source) {
            return new ResultsMovie(source);
        }

        @Override
        public ResultsMovie[] newArray(int size) {
            return new ResultsMovie[size];
        }
    };

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public String getOverview() {
        return overview;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getPopularity() {
        return popularity;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}