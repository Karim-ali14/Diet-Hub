package com.example.diethub;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.Objects;

public class Login_inActivity extends AppCompatActivity {
    private TextView newaccount;
    private SharedPref pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref = new SharedPref(this);

        Log.e("language",pref.getLagu());
        if (pref.getLagu().equals("ar")) {
            String languageToLoad = "ar";
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
        } else if (pref.getLagu().equals("en")){
            String languageToLoad = "en";
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
        }
        setContentView(R.layout.activity_login_in);
        newaccount = findViewById(R.id.newAccount);
        newaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (newaccount.getText().equals("عربى")) {
                    String languageToLoad = "en";
                    Locale locale = new Locale(languageToLoad);
                    Locale.setDefault(locale);
                    Configuration config = new Configuration();
                    config.locale = locale;
                    getBaseContext().getResources().updateConfiguration(config,
                            getBaseContext().getResources().getDisplayMetrics());
                    pref.setLangu("en");
                    newaccount.setText("English");
                    Intent intent = new Intent(Login_inActivity.this, Login_inActivity.class);
                    startActivity(intent);
                } else if (newaccount.getText().equals("English")){
                    String languageToLoad = "ar";
                    Locale locale = new Locale(languageToLoad);
                    Locale.setDefault(locale);
                    Configuration config = new Configuration();
                    config.locale = locale;
                    getBaseContext().getResources().updateConfiguration(config,
                            getBaseContext().getResources().getDisplayMetrics());
                    pref.setLangu("ar");
                    newaccount.setText("عربى");
                    Intent intent = new Intent(Login_inActivity.this, Login_inActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

//    public void onClick(View view) {
//        if (view.getId() ==R.id.EnterButton)
//            startActivity(new Intent(this,HomeActivity.class));
//        else if (view.getId() == R.id.newAccount)
//            startActivity(new Intent(this,Registration_Activity.class));
//        else if (view.getId() == R.id.ForgottenPassword)
//            startActivity(new Intent(this,Password_RecoveryActivity.class));
//    }
}
