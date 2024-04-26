package com.example.androidp2p.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidp2p.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListener();
    }

    private void setListener() {
        binding.textSignIn.setOnClickListener(v -> {
            OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled */) {
                @Override
                public void handleOnBackPressed() {
                    // Handle the back button event
                    finish();
                }
            };
            getOnBackPressedDispatcher().addCallback(this, callback);
            callback.handleOnBackPressed();
        });
    }
}