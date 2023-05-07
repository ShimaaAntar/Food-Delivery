package com.example.fooddelivery.views.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentPopularMenuBinding;
import com.example.fooddelivery.views.activities.DetailsMenuActivity;
import com.example.fooddelivery.views.adapter.MenuAdapter;
import com.example.fooddelivery.views.model.Menu;
import com.example.fooddelivery.views.model.Restaurants;

import java.util.ArrayList;
import java.util.List;

public class PopularMenuFragment extends Fragment implements MenuAdapter.OnClickItemListener{

    private FragmentPopularMenuBinding binding;
    private List<Menu> menus;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_popular_menu, container, false);
        menus = new ArrayList<>();
        menus.add(new Menu(R.drawable.menu2, "Herbal Pancake", "Warung Herbal", "7"));
        menus.add(new Menu(R.drawable.menu3, "Fruit Salad", "Wijie Resto", "5"));
        menus.add(new Menu(R.drawable.menu1, "Green Noddle", "Noodle Home", "15"));
        prepareMenuRV(menus);
        return binding.getRoot();
    }

    private void prepareMenuRV(List<Menu> menusList) {
        binding.rvPopularViewMoreMenu.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL
                , false));

        binding.rvPopularViewMoreMenu.setHasFixedSize(true);
        binding.rvPopularViewMoreMenu.setItemAnimator(new DefaultItemAnimator());
        MenuAdapter menuAdapter = new MenuAdapter(menusList,this);
        binding.rvPopularViewMoreMenu.setAdapter(menuAdapter);
    }

    @Override
    public void onClickMenuItem(Menu menu) {
        startActivity(new Intent(getActivity(), DetailsMenuActivity.class));
    }
}