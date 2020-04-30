package com.example.diethub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.Configuration;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {
    private SharedPref pref;
    ConstraintLayout ArabicLayout,EnglishLayout;
    ImageView selectedArab,selectedEng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref = new SharedPref(this);
        setContentView(R.layout.activity_language);

        selectedArab = findViewById(R.id.selectedArab);
        selectedEng = findViewById(R.id.selectedEng);
        if (!pref.getLagu().isEmpty()) {
            if (pref.getLagu().equals("ar")) {
                selectedEng.setVisibility(View.GONE);
                selectedArab.setVisibility(View.VISIBLE);
            } else if (pref.getLagu().equals("en")) {
                selectedEng.setVisibility(View.VISIBLE);
                selectedArab.setVisibility(View.GONE);
            }
        }else {
            selectedEng.setVisibility(View.GONE);
            selectedArab.setVisibility(View.GONE);
        }
        ArabicLayout = findViewById(R.id.ArabicLayout);
        EnglishLayout = findViewById(R.id.EnglishLayout);
        getWindow().getDecorView().setSystemUiVisibility
                (View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR |
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        ArabicLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String languageToLoad = "ar";
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                pref.setLangu("ar");
                Intent intent = new Intent(LanguageActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        EnglishLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String languageToLoad = "en";
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                pref.setLangu("en");
                Intent intent = new Intent(LanguageActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void BackButton(View view) {
        finish();
    }
}
