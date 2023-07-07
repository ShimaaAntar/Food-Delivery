package com.example.fooddelivery.views.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentPopularRestaurantBinding;
import com.example.fooddelivery.views.activities.DetailsMenuActivity;
import com.example.fooddelivery.views.adapter.RestaurantAdapter;
import com.example.fooddelivery.views.api.ApiManager;
import com.example.fooddelivery.views.api.WebServices;
import com.example.fooddelivery.views.model.RestaurantItem;
import com.example.fooddelivery.views.model.RestaurentResponse;
import com.example.fooddelivery.views.ui.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class PopularRestaurantFragment extends Fragment implements RestaurantAdapter.OnClickItemListener {
    FragmentPopularRestaurantBinding binding;
    RestaurantAdapter restaurantAdapter;
    private List<RestaurantItem> restaurants;
    private WebServices apiService;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_popular_restaurant,container, false);

        restaurants=new ArrayList<>();
        prepareRestaurantRV(restaurants);
        makeApiRequestResto();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GridLayoutManager manager2 = new GridLayoutManager(getActivity(),2);
        manager2.setOrientation(LinearLayoutManager.VERTICAL);
        binding.rvPopularRestro.setLayoutManager(manager2);
    }
    private void prepareRestaurantRV(List<RestaurantItem> restaurantsList){
        binding.rvPopularRestro.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL
                , false));
        binding.rvPopularRestro.setHasFixedSize(true);
        binding.rvPopularRestro.setItemAnimator(new DefaultItemAnimator());
        binding.rvPopularRestro.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        restaurantAdapter = new RestaurantAdapter(restaurantsList, (RestaurantAdapter.OnClickItemListener) this);
        binding.rvPopularRestro.setAdapter(restaurantAdapter);
    }
    public void makeApiRequestResto() {
        // Get the Retrofit instance with the token interceptor
        Retrofit retrofit = ApiManager.getClient();
        // Create an instance of the API service
        apiService = retrofit.create(WebServices.class);
        // Make the API request
        Call<RestaurentResponse> call = apiService.getAllRestaurent();
        call.enqueue(new Callback<RestaurentResponse>() {
            @Override
            public void onResponse(Call<RestaurentResponse> call, Response<RestaurentResponse> response) {
                if (response.isSuccessful()) {
                    RestaurentResponse data = response.body();
                    restaurantAdapter.setList(data.getData());
                } else {
                    Log.e("shimaa", "Response unsuccessful: " + response.code());
                }
            }
            @Override
            public void onFailure(Call<RestaurentResponse> call, Throwable t) {
                Log.e("shimaa", t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void onClickRestroItem(RestaurantItem restaurants) {
        Intent intent = new Intent(getActivity(), DetailsMenuActivity.class);
        intent.putExtra(Constants.RESTRO_NAME, restaurants.getName());
        startActivity(intent);
    }
}