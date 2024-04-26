package com.example.androidp2p.repository;

import com.example.androidp2p.remote.FirebaseClient;
import com.example.androidp2p.util.SuccessCallBack;

public class MainRepository {
    private FirebaseClient firebaseClient;
    private String currentUsername;
    private void updateCurrentUsername(String username){
        this.currentUsername = username;
    }

    private MainRepository(){
        this.firebaseClient = new FirebaseClient();
    }

    private static MainRepository instance;
    public static MainRepository getInstance(){
        if (instance == null){
            instance = new MainRepository();
        }

        return instance;
    }
    public void login(String username, SuccessCallBack callBack){
        firebaseClient.login(username,()->{
            updateCurrentUsername(username);
            callBack.onSuccess();
        });
    }
}
