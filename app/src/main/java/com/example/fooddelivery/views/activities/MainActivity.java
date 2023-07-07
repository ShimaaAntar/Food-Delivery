package com.example.fooddelivery.views.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.ActivityHomeBinding;
import com.example.fooddelivery.views.api.ApiManager;
import com.example.fooddelivery.views.api.WebServices;
import com.example.fooddelivery.views.fragment.CartFragment;
import com.example.fooddelivery.views.fragment.ChatFragment;
import com.example.fooddelivery.views.fragment.HomeFragment;
import com.example.fooddelivery.views.fragment.ProfileFragment;
import com.example.fooddelivery.views.model.RestaurentResponse;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private Fragment fragment;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_home);

        bottomNavigationView=binding.bottomNavigation;
        /*binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.homeFragment:
                        fragment = new HomeFragment();
                        loadFragment(fragment);
                        showBottomView();
                        break;
                    case R.id.profileFragment:
                        fragment = new ProfileFragment();
                        loadFragment(fragment);
                        showBottomView();
                        break;
                    case R.id.cartFragment:
                        fragment = new CartFragment();
                        loadFragment(fragment);
                        showBottomView();
                        break;
                    case R.id.chatFragment:
                        fragment = new ChatFragment();
                        loadFragment(fragment);
                        showBottomView();
                        break;
                    default:
                        hideBottomView();
                }
                return false;
            }
        });*/
        //binding.bottomNavigation.setSelectedItemId(R.id.homeFragment);
        //NavController navController= Navigation.findNavController(this,R.id.nav_host_fragment);
        NavController navController= Navigation.findNavController(this,R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
    }

    private void showBottomView() {
        binding.bottomNavigation.setVisibility(View.VISIBLE);
    }

    private void hideBottomView() {
        binding.bottomNavigation.setVisibility(View.GONE);
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(binding.bottomNavigation.getId(), fragment)
                .commitAllowingStateLoss();
    }



}
