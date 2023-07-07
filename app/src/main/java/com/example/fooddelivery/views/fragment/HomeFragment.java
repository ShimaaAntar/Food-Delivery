package com.example.fooddelivery.views.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentHomeBinding;
import com.example.fooddelivery.views.activities.DetailsMenuActivity;
import com.example.fooddelivery.views.adapter.MenuAdapter;
import com.example.fooddelivery.views.adapter.RestaurantAdapter;
import com.example.fooddelivery.views.api.ApiManager;
import com.example.fooddelivery.views.api.WebServices;
import com.example.fooddelivery.views.model.Menu;
import com.example.fooddelivery.views.model.MenuItem;
import com.example.fooddelivery.views.model.MenuResponse;
import com.example.fooddelivery.views.model.RestaurantItem;
import com.example.fooddelivery.views.model.Restaurants;
import com.example.fooddelivery.views.model.RestaurentResponse;
import com.example.fooddelivery.views.ui.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment
        implements MenuAdapter.OnClickItemListener, RestaurantAdapter.OnClickItemListener {
    private FragmentHomeBinding binding;
    private RestaurantAdapter restaurantAdapter;
    private MenuAdapter menuAdapter;
    private List<RestaurantItem>  restaurants;
    private List<MenuItem> menu;
    private WebServices apiService;
    TextView moreResto;
    TextView tvMoreMenu;
    ImageButton tvFilter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,container, false);

        makeApiRequestResto();
        makeApiRequestFood();
        restaurants = new ArrayList<>();
        menu = new ArrayList<>();
        prepareRestaurantRV(restaurants);
        prepareMenuRV(menu);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        moreResto=view.findViewById(R.id.viewMoreRestroTV);
        moreResto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_homeFragment2_to_popularRestaurantFragment);
            }
        });
        tvMoreMenu=view.findViewById(R.id.viewMoreMenuTV);
        tvMoreMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_homeFragment2_to_popularMenuFragment2);
            }
        });
        tvFilter=view.findViewById(R.id.filterBtn);
        tvFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_homeFragment2_to_filterFragment);
            }
        });
    }
    private void prepareRestaurantRV(List<RestaurantItem> restaurantsList){
        binding.rvNearestRestaurant.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL
                , false));

        binding.rvNearestRestaurant.setHasFixedSize(true);
        binding.rvNearestRestaurant.setItemAnimator(new DefaultItemAnimator());
        binding.rvNearestRestaurant.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        restaurantAdapter = new RestaurantAdapter(restaurantsList, (RestaurantAdapter.OnClickItemListener) this);
        binding.rvNearestRestaurant.setAdapter(restaurantAdapter);
    }
    private void prepareMenuRV(List<MenuItem> menusList){
        binding.rvPopularMenu.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL
                , false));

        binding.rvPopularMenu.setHasFixedSize(true);
        binding.rvPopularMenu.setItemAnimator(new DefaultItemAnimator());
        menuAdapter = new MenuAdapter(menusList, (MenuAdapter.OnClickItemListener) this);
        binding.rvPopularMenu.setAdapter(menuAdapter);

    }

    @Override
    public void onClickRestroItem(RestaurantItem restaurants) {
        Intent intent = new Intent(getActivity(), DetailsMenuActivity.class);
        intent.putExtra(Constants.RESTRO_NAME, restaurants.getName());
        startActivity(intent);
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