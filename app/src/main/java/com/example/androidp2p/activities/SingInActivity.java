package com.example.androidp2p.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidp2p.databinding.ActivitySingInBinding;
import com.example.androidp2p.repository.MainRepository;
import com.google.firebase.database.FirebaseDatabase;

public class SingInActivity extends AppCompatActivity {

    private ActivitySingInBinding binding;
    private MainRepository mainRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseDatabase.getInstance().getReference().child("sergio").setValue("Testing3");
        EdgeToEdge.enable(this);
        binding = ActivitySingInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
    }

    private void setListeners(){
        mainRepository = MainRepository.getInstance();
        binding.buttonSignIn.setOnClickListener(v -> {
            //login to Firebase here
            mainRepository.login(
                    binding.inputEmail.getText().toString(),()->{
                        //if successful then want to move to messageActivity
                        startActivity(new Intent(getApplicationContext(), MessageActivity.class));
                    }
            );

        });
        binding.textCreateNewAccount.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(),SignUpActivity.class));
        });
    }
}