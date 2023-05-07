package com.example.fooddelivery.views.firstOpenApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.ActivityPaymentBinding;

public class PaymentActivity extends AppCompatActivity {

    private ActivityPaymentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(PaymentActivity.this,R.layout.activity_payment);
        binding.button.setOnClickListener(v -> goToNextScreen());
    }

    private void goToNextScreen() {
        Intent intent=new Intent(PaymentActivity.this,UploadPhotoActivity.class);
        startActivity(intent);
    }
}