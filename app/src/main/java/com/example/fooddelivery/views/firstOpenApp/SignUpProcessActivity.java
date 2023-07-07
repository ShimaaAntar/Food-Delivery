package com.example.fooddelivery.views.firstOpenApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.ActivitySignUpProcessBinding;

public class SignUpProcessActivity extends AppCompatActivity {
    private ActivitySignUpProcessBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(SignUpProcessActivity.this,R.layout.activity_sign_up_process);
        binding.button.setOnClickListener(v -> goToNextScreen());
    }
    private void goToNextScreen() {
        Intent intent=new Intent(SignUpProcessActivity.this,PaymentActivity.class);
        startActivity(intent);
    }
}