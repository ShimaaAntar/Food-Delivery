package com.example.fooddelivery.views.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    WebServices webServices;
    private static final String BASE_URL="http://206.189.103.8/api/";
    public static Retrofit getClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        // Add the authentication interceptor to the OkHttp client
        httpClient.addInterceptor(new AuthInterceptor("11|qqAoHzA5SKgK2i8MuwAFKwhrKO5K1s2D4M217Lr5"));

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }
}
