package com.example.androidp2p.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidp2p.databinding.ActivityChatBinding;
import com.example.androidp2p.models.User;
import com.example.androidp2p.utilities.Constants;

public class ChatActivity extends AppCompatActivity {

    private ActivityChatBinding binding;
    private User receiverUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       setListeners();
       loadReceiverDetails();
    }

    private void setListeners(){
        binding.imageBack.setOnClickListener(v -> {
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

    private void loadReceiverDetails(){
        receiverUser = (User) getIntent().getSerializableExtra(Constants.KEY_USER);
        binding.textName.setText(receiverUser.name);
    }
}