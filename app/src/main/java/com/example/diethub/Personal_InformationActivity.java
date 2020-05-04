package com.example.diethub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Personal_InformationActivity extends AppCompatActivity {
    Button ModifyButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal__information);

        getWindow().getDecorView().setSystemUiVisibility
                (View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR |
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        ModifyButton = findViewById(R.id.ModifyButton);
        ModifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Personal_InformationActivity.this,Modify_personal_InfoActivity.class));
            }
        });
    }

    public void BackButton(View view) {
        finish();
    }
}
