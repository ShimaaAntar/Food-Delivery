package com.example.fooddelivery.views.api;

import com.example.fooddelivery.views.model.MenuResponse;
import com.example.fooddelivery.views.model.Restaurants;
import com.example.fooddelivery.views.model.RestaurentResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebServices {

    @GET("restaurent")
    Call<RestaurentResponse>getAllRestaurent();
    @GET("food")
    Call<MenuResponse>getAllMenu();
    /*@GET("users/{id}")
    Call<UserResponse> getUserById(@Path("id") String userId);*/
}
