package com.tp.tp3.service;

import com.google.gson.Gson;
import com.tp.tp3.model.Chiste;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ChisteService {
    private static final String API_URL = "https://official-joke-api.appspot.com/random_joke";
    private static final Gson gson = new Gson();
    private static final OkHttpClient client = new OkHttpClient();

    public static Chiste obtenerChiste() {
        Chiste chiste = null;
        try {
            Request request = new Request.Builder().url(API_URL).build();
            Response response = client.newCall(request).execute();

            if (response.isSuccessful() && response.body() != null) {
                chiste = gson.fromJson(response.body().string(), Chiste.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiste;
    }

}
