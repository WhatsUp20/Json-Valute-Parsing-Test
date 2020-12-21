package com.example.appforfocus.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService networkService;
    public static final String BASE_URL = "https://www.cbr-xml-daily.ru/";
    private Retrofit retrofit;
    private static final Object LOCK = new Object();

    private NetworkService() {
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    public static NetworkService getInstance() {
        synchronized (LOCK) {
            if (networkService == null) {
                networkService = new NetworkService();
            }
        }

        return  networkService;
    }

    public NetworkApi getAllApi() {
        return retrofit.create(NetworkApi.class);
    }
}
