package com.example.diethub;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    ImageView Icon,favoriteIcon;
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
        favoriteIcon = findViewById(R.id.favoriteIcon);
        favoriteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogForFavorite();
            }
        });
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

    private void dialogForFavorite(){
        final AlertDialog.Builder Adialog = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_favorite, null);
        LinearLayout ContainerButton = view.findViewById(R.id.ContainerButton);
        Adialog.setView(view);
        final AlertDialog dialog1 = Adialog.create();
        dialog1.setCanceledOnTouchOutside(true);
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog1.show();
        ContainerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuOfResturantsActivity.this, FavoriteActivity.class));
            }
        });
    }

    private void SetupViewPagerAndTab(){
        viewPager = findViewById(R.id.viewPagerMenu);
        tabLayout = findViewById(R.id.tab);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new AllOfFood(data,true),"كل الوجبات");
        viewPagerAdapter.addFragment(new AllOfFood(data,false),"الأكثر طلبا");
        viewPagerAdapter.addFragment(new AllOfFood(data,false),"اللحوك");
        viewPagerAdapter.addFragment(new AllOfFood(data,false),"الشرقي");
        viewPagerAdapter.addFragment(new AllOfFood(data,false),"الاسماك");
        viewPager.setAdapter(viewPagerAdapter);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.details) {
            startActivity(new Intent(this, Details_Activity.class));
        } else if (view.getId() == R.id.packages) {
            startActivity(new Intent(this, PackagesActivity.class));
        } else if (view.getId() == R.id.ListIcon) {
            startActivity(new Intent(this, ListOrderActivity2.class));
        }
    }
}