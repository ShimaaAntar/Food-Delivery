package com.example.fooddelivery.views.firstOpenApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.ActivitySingeUpSuccessBinding;
import com.example.fooddelivery.views.activities.MainActivity;

public class SignUpSuccessActivity extends AppCompatActivity {

    private ActivitySingeUpSuccessBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(SignUpSuccessActivity.this,R.layout.activity_singe_up_success);
        binding.tryOrderBtn.setOnClickListener(v -> goToNextScreen());
    }

    private void goToNextScreen() {
        Intent intent=new Intent(SignUpSuccessActivity.this, MainActivity.class);
        startActivity(intent);
    }
}