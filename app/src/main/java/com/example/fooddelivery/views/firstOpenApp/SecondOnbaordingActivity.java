package com.example.fooddelivery.views.firstOpenApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.ActivityScreen3Binding;

public class SecondOnbaordingActivity extends AppCompatActivity {
    private ActivityScreen3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(SecondOnbaordingActivity.this,R.layout.activity_screen3);
        binding.button.setOnClickListener(v -> goToNextScreen());
    }

    private void goToNextScreen() {
        Intent intent=new Intent(SecondOnbaordingActivity.this, SignInActivity.class);
        startActivity(intent);
    }
}