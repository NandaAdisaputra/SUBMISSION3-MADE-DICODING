package com.nandaadisaputra.submission3dicodingmade.model.response;

import com.google.gson.annotations.SerializedName;
import com.nandaadisaputra.submission3dicodingmade.model.results.ResultsMovie;

import java.util.List;

public class TvResponse {

    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private List<ResultsMovie> results;

    public TvResponse(int page, List<ResultsMovie> results) {
        this.page = page;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public List<ResultsMovie> getResults() {
        return results;
    }

}