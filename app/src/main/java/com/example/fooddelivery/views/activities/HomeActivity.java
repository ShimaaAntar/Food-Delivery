package com.example.fooddelivery.views.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.ActivityHomeBinding;
import com.example.fooddelivery.views.firstOpenApp.PaymentActivity;
import com.example.fooddelivery.views.fragment.CartFragment;
import com.example.fooddelivery.views.fragment.ChatFragment;
import com.example.fooddelivery.views.fragment.HomeFragment;
import com.example.fooddelivery.views.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(HomeActivity.this, R.layout.activity_home);
        binding.bottomNavigation.setSelectedItemId(R.id.homeFragment);
        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homeFragment:
                        fragment=new HomeFragment();
                        loadFragment(fragment);
                        showBottomView();
                        break;
                    case R.id.profileFragment:
                        fragment=new ProfileFragment();
                        loadFragment(fragment);
                        showBottomView();
                        break;
                    case R.id.cartFragment:
                        fragment=new CartFragment();
                        loadFragment(fragment);
                        showBottomView();
                        break;
                    case R.id.chatFragment:
                        fragment=new ChatFragment();
                        loadFragment(fragment);
                        showBottomView();
                        break;
                    default:
                        hideBottomView();
                }
                return false;
            }
        });
    }
    private void showBottomView(){
        binding.bottomNavigation.setVisibility(View.VISIBLE);
    }
    private void hideBottomView(){
        binding.bottomNavigation.setVisibility(View.GONE);
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(binding.fragmentContainer.getId(), fragment)
                .commitAllowingStateLoss();


    }
}

