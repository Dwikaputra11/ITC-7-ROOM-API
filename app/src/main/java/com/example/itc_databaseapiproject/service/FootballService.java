package com.example.itc_databaseapiproject.service;

import com.example.itc_databaseapiproject.model.DataItem;
import com.example.itc_databaseapiproject.model.FootballResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FootballService {

    Retrofit retrofit = null;

    public FootballAPI getAPI(){
        if(retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(FootballAPI.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(FootballAPI.class);
    }

    public void getLeague(final FootballListener<List<DataItem>> listener){
        getAPI().getLeague().enqueue(new Callback<FootballResponse>() {
            @Override
            public void onResponse(Call<FootballResponse> call, Response<FootballResponse> response) {
                FootballResponse data = response.body();

                if(data != null && data.getData() != null){
                    listener.onSuccess(data.getData());
                }
            }

            @Override
            public void onFailure(Call<FootballResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }
}
