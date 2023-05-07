package com.example.fooddelivery.views.firstOpenApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {
    private ActivitySignInBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(SignInActivity.this,R.layout.activity_sign_in);
        binding.loginBtn.setOnClickListener(v -> goToNextScreen());
    }

    private void goToNextScreen() {
        Intent intent=new Intent(SignInActivity.this,SignUpActivity.class);
        startActivity(intent);

    }
}
