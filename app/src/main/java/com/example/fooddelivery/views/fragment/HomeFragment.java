package com.example.fooddelivery.views.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentHomeBinding;
import com.example.fooddelivery.views.activities.DetailsMenuActivity;
import com.example.fooddelivery.views.adapter.MenuAdapter;
import com.example.fooddelivery.views.adapter.RestaurantAdapter;
import com.example.fooddelivery.views.model.Menu;
import com.example.fooddelivery.views.model.Restaurants;
import com.example.fooddelivery.views.ui.Constants;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment
        implements MenuAdapter.OnClickItemListener, RestaurantAdapter.OnClickItemListener {
    private FragmentHomeBinding binding;
    private RestaurantAdapter restaurantAdapter;
    private MenuAdapter menuAdapter;
    private List<Restaurants>  restaurants;
    private List<Menu> menu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,container, false);

        restaurants = new ArrayList<>();
        restaurants.add(new Restaurants(R.drawable.restaurant1, "Vegan Resto", "12 Min"));
        restaurants.add(new Restaurants(R.drawable.restaurant2, "Healthy Food", "8 Min"));
        restaurants.add(new Restaurants(R.drawable.restaurant3, "Good Food", "12 Min"));

        menu = new ArrayList<>();
        menu.add(new Menu(R.drawable.menu1, "Herbal Pancake", "Warung Herbal", "7"));
        menu.add(new Menu(R.drawable.menu2, "Fruit Salad", "Wijie Resto", "5"));

        prepareRestaurantRV(restaurants);
        prepareMenuRV(menu);
        return binding.getRoot();
    }
    private void prepareRestaurantRV(List<Restaurants> restaurantsList){
        binding.rvNearestRestaurant.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL
                , false));

        binding.rvNearestRestaurant.setHasFixedSize(true);
        binding.rvNearestRestaurant.setItemAnimator(new DefaultItemAnimator());
        binding.rvNearestRestaurant.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        restaurantAdapter = new RestaurantAdapter(restaurantsList, (RestaurantAdapter.OnClickItemListener) this);
        binding.rvNearestRestaurant.setAdapter(restaurantAdapter);
    }
    private void prepareMenuRV(List<Menu> menusList){
        binding.rvPopularMenu.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL
                , false));

        binding.rvPopularMenu.setHasFixedSize(true);
        binding.rvPopularMenu.setItemAnimator(new DefaultItemAnimator());
        menuAdapter = new MenuAdapter(menusList, (MenuAdapter.OnClickItemListener) this);
        binding.rvPopularMenu.setAdapter(menuAdapter);

    }

    @Override
    public void onClickRestroItem(Restaurants restaurants) {
        Intent intent = new Intent(getActivity(), DetailsMenuActivity.class);
        intent.putExtra(Constants.RESTRO_NAME, restaurants.getRestoName());
        startActivity(intent);
    }

    @Override
    public void onClickMenuItem(Menu menu) {
        startActivity(new Intent(getActivity(), DetailsMenuActivity.class));
    }
}