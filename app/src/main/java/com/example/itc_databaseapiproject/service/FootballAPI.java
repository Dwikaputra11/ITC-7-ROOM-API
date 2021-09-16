package com.example.itc_databaseapiproject.service;

import com.example.itc_databaseapiproject.model.FootballResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FootballAPI {
    String URL_BASE = "https://api-football-standings.azharimm.site/";

    @GET("leagues")
    Call<FootballResponse> getLeague();

}
