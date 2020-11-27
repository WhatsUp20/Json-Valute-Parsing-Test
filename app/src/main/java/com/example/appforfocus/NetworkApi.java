package com.example.appforfocus;

import com.example.appforfocus.focus.CurrencyResponce;


import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkApi {
    @GET("daily_json.js")
    Call<CurrencyResponce> getAll();
}
