package com.example.diethub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.Objects;

public class Login_inActivity extends AppCompatActivity {
    EditText Phone,Password;
    ConstraintLayout Layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_in);
        init();
    }
    private void init(){
        getWindow().getDecorView().setSystemUiVisibility
                (View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR |
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        Phone = findViewById(R.id.PhoneNumber);
        Password = findViewById(R.id.Password);
        Layout = findViewById(R.id.Layout);
        Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(v instanceof EditText))
                    closeKeyBoard();
            }
        });
    }

    private void closeKeyBoard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(this.getWindow().getDecorView().getRootView().getWindowToken(), 0);
        Phone.clearFocus();
        Password.clearFocus();
    }

    public void onClick(View view) {
        if (view.getId() ==R.id.EnterButton) {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }
       else if (view.getId() == R.id.newAccount)
            startActivity(new Intent(this,Registration_Activity.class));
        else if (view.getId() == R.id.ForgottenPassword)
            startActivity(new Intent(this,Password_RecoveryActivity.class));
    }
}
