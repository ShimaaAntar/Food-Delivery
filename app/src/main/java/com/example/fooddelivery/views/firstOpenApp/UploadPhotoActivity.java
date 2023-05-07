package com.example.fooddelivery.views.firstOpenApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.ActivityUploadPhotoBinding;

public class UploadPhotoActivity extends AppCompatActivity {

    private ActivityUploadPhotoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(UploadPhotoActivity.this,R.layout.activity_upload_photo);
        binding.button.setOnClickListener(v -> goToNextScreen());
    }

    private void goToNextScreen() {
        Intent intent=new Intent(UploadPhotoActivity.this,SetLocationActivity.class);
        startActivity(intent);
    }
}