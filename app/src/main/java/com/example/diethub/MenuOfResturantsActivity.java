package com.example.diethub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.diethub.Adapters.ViewPagerAdapter;
import com.example.diethub.Fragments.AllOfFood;
import com.example.diethub.Models.DataOfRestaurants;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

public class MenuOfResturantsActivity extends AppCompatActivity {
    DataOfRestaurants data;
    TextView title;
    RatingBar rating;
    ImageView Icon;
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_of_resturants);
        data = getIntent().getExtras().getParcelable("MenuId");
        title = findViewById(R.id.title);
        title.setText(data.getName());
        Icon = findViewById(R.id.Icon);
        Picasso.with(this).load(data.getIcon()).into(Icon);
        rating = findViewById(R.id.RatingMenu);
        rating.setRating(Float.parseFloat(data.getRating()));
        SetupViewPagerAndTab();
        tabLayout.setupWithViewPager(viewPager);
        getWindow().getDecorView().setSystemUiVisibility
                (View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR |
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }
    public void BackButton(View view) {
        finish();
    }

    private void SetupViewPagerAndTab(){
        viewPager = findViewById(R.id.viewPagerMenu);
        tabLayout = findViewById(R.id.tab);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new AllOfFood(data),"كل الوجبات");
        viewPagerAdapter.addFragment(new AllOfFood(data),"الأكثر طلبا");
        viewPagerAdapter.addFragment(new AllOfFood(data),"اللحوك");
        viewPagerAdapter.addFragment(new AllOfFood(data),"الشرقي");
        viewPagerAdapter.addFragment(new AllOfFood(data),"الاسماك");
        viewPager.setAdapter(viewPagerAdapter);
    }
}