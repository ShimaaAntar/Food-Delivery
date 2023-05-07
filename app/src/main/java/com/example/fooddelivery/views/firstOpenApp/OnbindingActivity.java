package com.example.fooddelivery.views.firstOpenApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.ActivityScreen2Binding;
import com.example.fooddelivery.databinding.ActivitySignInBinding;


public class OnbindingActivity extends AppCompatActivity {
    private ActivityScreen2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(OnbindingActivity.this, R.layout.activity_screen2);
        binding.buttonNxt.setOnClickListener(v -> goToNextScreen());
    }

    private void goToNextScreen() {
        Intent intent = new Intent(OnbindingActivity.this, SecondOnbaordingActivity.class);
        startActivity(intent);
    }

}