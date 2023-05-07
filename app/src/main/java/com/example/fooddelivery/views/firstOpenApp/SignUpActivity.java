package com.example.fooddelivery.views.firstOpenApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(SignUpActivity.this,R.layout.activity_sign_up);
        binding.createBtn.setOnClickListener(v -> goToNextScreen());
    }

    private void goToNextScreen() {
        Intent intent=new Intent(SignUpActivity.this,SignUpProcessActivity.class);
        startActivity(intent);
    }
}