package com.example.appforfocus.api;

import com.example.appforfocus.Valutes;
import com.example.appforfocus.focus.CurrencyResponce;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkApi {
    @GET("daily_json.js")
    Observable<CurrencyResponce> getAllResponse();
}
