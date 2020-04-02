package com.example.diethub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    startActivity(new Intent(getApplicationContext(), RestaurantsActivity.class));
                    finish(); // finish(); because This Activity close After move To Next Activity And Next Activity will Be Launcher
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
