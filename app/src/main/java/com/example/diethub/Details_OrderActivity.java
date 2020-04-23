package com.example.diethub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class Details_OrderActivity extends AppCompatActivity {
    TextView CountText,NumberOfRating;
    LinearLayout CountLayout,CC,DelegateLayout;
    RatingBar ratingBar;
    ImageView VisaIcon;
    View line3,line8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details__order);
        init();
        ChangeOfDesginByType(getIntent().getExtras().getInt("Type"));
    }

    public void BackButton(View view) {
        finish();
    }

    private void init(){
        getWindow().getDecorView().setSystemUiVisibility
                (View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR |
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        CountText = findViewById(R.id.countText);
        NumberOfRating = findViewById(R.id.NumberOfRating);
        CountLayout = findViewById(R.id.CountLayout);
        CC = findViewById(R.id.CC);
        DelegateLayout = findViewById(R.id.DelegateLayout);
        ratingBar = findViewById(R.id.ratingBar);
        VisaIcon = findViewById(R.id.VisaIcon);
        line3 = findViewById(R.id.line3);
        line8 = findViewById(R.id.line8);
    }

    private void ChangeOfDesginByType(int type){
        if (type == 0){
            CountText.setTextColor(getResources().getColor(R.color.colorPrimary));
            CC.setVisibility(View.GONE);
            line3.setVisibility(View.GONE);
            DelegateLayout.setVisibility(View.GONE);
            line8.setVisibility(View.GONE);
        }
        else if(type == 1){
            CountLayout.setVisibility(View.GONE);
            ratingBar.setVisibility(View.GONE);
            NumberOfRating.setVisibility(View.GONE);
            VisaIcon.setVisibility(View.GONE);
        }
    }

}
