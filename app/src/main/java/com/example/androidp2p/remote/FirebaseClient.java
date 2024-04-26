package com.example.androidp2p.remote;

import com.example.androidp2p.util.SuccessCallBack;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

public class FirebaseClient {

    private final Gson gson = new Gson();
    private final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private String currentUsername;

    private static final String LATEST_EVENT_FIELD_NAME = "Latest_Event";

    public void login(String username, SuccessCallBack callBack){
        databaseReference.child(username).setValue("").addOnCompleteListener(task -> {
            currentUsername = username;
            callBack.onSuccess();
        });

    }

    public void sendMessageToOtherUser(){

    }

    public void observeIncomingLatestEvent(){

    }
}
