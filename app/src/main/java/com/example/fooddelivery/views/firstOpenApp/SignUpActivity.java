package com.example.fooddelivery.views.firstOpenApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.ActivitySignUpBinding;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    private ActivitySignUpBinding binding;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    SharedPreferences sharedPreferences;
    String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    String userRegex = "^(?![0-9])[a-zA-Z0-9_]{3,15}$";
    String passwordRegex = " ^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(SignUpActivity.this, R.layout.activity_sign_up);
        progressDialog=new ProgressDialog(this);
        binding.createBtn.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     String userName=binding.usernameEditText.getText().toString();
                                                     String email=binding.emailEditText.getText().toString();
                                                     String password=binding.passwordEditText.getText().toString();
                                                     onSignUpClicked(userName, email, password);
                                                 }
                                             }
                );
        binding.alreadyHaveAccount.setOnClickListener(v -> onSignInClicked());

    }

    private void goToNextScreen() {
        Intent intent = new Intent(SignUpActivity.this, SignUpProcessActivity.class);
        startActivity(intent);
    }

    public void onSignInClicked() {
        Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
        startActivity(intent);
    }
    public void onSignUpClicked(String username, String email, String password) {
        firebaseAuth = FirebaseAuth.getInstance();
        //db = FirebaseDatabase.getInstance();
        //reference = db.getReference("Users");
        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);

        if (!username.matches(userRegex)) {
            showErrorMessage("Enter a valid username");
        } else if (!email.matches(emailRegex)) {
            showErrorMessage("Enter a valid email");
        } /*else if (!password.matches(passwordRegex)) {
            showErrorMessage("- At least 8 characters.\n" +
                    "- At least one letter (uppercase or lowercase).\n" +
                    "- At least one digit.");
        } */else {
            showProgressDialog();

            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", username);
                    editor.putString("email", email);
                    editor.putString("password", password);
                    editor.putBoolean("isLoggedIn", true);
                    editor.apply();
                    dismissProgressDialog();
                    showRegistrationSuccess();
                    goToNextScreen();

                } else {
                    dismissProgressDialog();
                    showErrorMessage(task.getException().getLocalizedMessage());
                }
            });
        }
    }

    public void showErrorMessage(String errorMessage) {
        if(errorMessage=="Enter a valid username"){
            binding.usernameEditText.setError(errorMessage);}
        else if (errorMessage=="Enter a valid email"){
            binding.emailEditText.setError(errorMessage);
        }else if (errorMessage=="- At least 8 characters.\n" +
                "- At least one letter (uppercase or lowercase).\n" +
                "- At least one digit."){
            binding.passwordEditText.setError(errorMessage);
        }
    }
    public void showProgressDialog() {
        progressDialog.setMessage("Registration...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }
    public void dismissProgressDialog() {
        progressDialog.dismiss();
    }
    public void showRegistrationSuccess() {
        Toast.makeText(this, "Sign up is successful", Toast.LENGTH_SHORT).show();
    }
}