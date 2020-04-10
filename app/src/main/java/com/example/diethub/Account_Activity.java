package com.example.diethub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class Account_Activity extends AppCompatActivity {
    CircleImageView circleImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_);
        circleImageView = findViewById(R.id.profile_image);
        circleImageView.setImageResource(R.drawable.chiken);

        getWindow().getDecorView().setSystemUiVisibility
                (View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR |
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.cardView6)
            Toast.makeText(this, "6", Toast.LENGTH_SHORT).show();
        else if (view.getId() == R.id.cardView2)
            Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
        else if (view.getId() == R.id.cardView3)
            Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
        else if (view.getId() == R.id.CardView)
            startActivity(new Intent(this,Wallet_Activity.class));
    }
}