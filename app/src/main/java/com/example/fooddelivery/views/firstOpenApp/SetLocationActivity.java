package com.example.fooddelivery.views.firstOpenApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.ActivitySetLocationBinding;

public class SetLocationActivity extends AppCompatActivity {

    private ActivitySetLocationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(SetLocationActivity.this,R.layout.activity_set_location);
        binding.nextBtn.setOnClickListener(v -> goToNextScreen());
    }

    private void goToNextScreen() {
        Intent intent=new Intent(SetLocationActivity.this,SignUpSuccessActivity.class);
        startActivity(intent);
    }
}