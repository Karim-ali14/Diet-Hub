package com.example.diethub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login_inActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_in);
        getWindow().getDecorView().setSystemUiVisibility
                (View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR |
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    public void onClick(View view) {
        if (view.getId() ==R.id.EnterButton)
            startActivity(new Intent(this,HomeActivity.class));
        else if (view.getId() == R.id.newAccount)
            startActivity(new Intent(this,Registration_Activity.class));
        else if (view.getId() == R.id.ForgottenPassword)
            startActivity(new Intent(this,Password_RecoveryActivity.class));
    }
}
