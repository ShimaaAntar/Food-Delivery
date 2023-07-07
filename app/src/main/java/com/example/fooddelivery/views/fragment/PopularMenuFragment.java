package com.example.fooddelivery.views.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentPopularMenuBinding;
import com.example.fooddelivery.views.activities.DetailsMenuActivity;
import com.example.fooddelivery.views.adapter.MenuAdapter;
import com.example.fooddelivery.views.api.ApiManager;
import com.example.fooddelivery.views.api.WebServices;
import com.example.fooddelivery.views.model.Menu;
import com.example.fooddelivery.views.model.MenuItem;
import com.example.fooddelivery.views.model.MenuResponse;
import com.example.fooddelivery.views.model.Restaurants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PopularMenuFragment extends Fragment implements MenuAdapter.OnClickItemListener{

    private FragmentPopularMenuBinding binding;
     MenuAdapter menuAdapter;
    private WebServices apiService;
    private List<MenuItem> menus;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_popular_menu, container, false);
        menus = new ArrayList<>();
        prepareMenuRV(menus);
        makeApiRequestFood();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void prepareMenuRV(List<MenuItem> menusList) {
        binding.rvPopularViewMoreMenu.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        binding.rvPopularViewMoreMenu.setHasFixedSize(true);
        binding.rvPopularViewMoreMenu.setItemAnimator(new DefaultItemAnimator());
        menuAdapter = new MenuAdapter(menusList, this);
        binding.rvPopularViewMoreMenu.setAdapter(menuAdapter);
    }

    public void makeApiRequestFood() {
        // Get the Retrofit instance with the token interceptor
        Retrofit retrofit = ApiManager.getClient();
        // Create an instance of the API service
        apiService = retrofit.create(WebServices.class);
        // Make the API request
        Call<MenuResponse> call = apiService.getAllMenu();
        call.enqueue(new Callback<MenuResponse>() {
            @Override
            public void onResponse(Call<MenuResponse> call, Response<MenuResponse> response) {
                if (response.isSuccessful()) {
                    MenuResponse data = response.body();
                    menuAdapter.setList(data.getData());
                } else {
                    Log.e("shimaa", "Response unsuccessful: " + response.code());
                }
            }
            @Override
            public void onFailure(Call<MenuResponse> call, Throwable t) {
                Log.e("shimaa", t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void onClickMenuItem(MenuItem menu) {
        startActivity(new Intent(getActivity(), DetailsMenuActivity.class));
    }
}