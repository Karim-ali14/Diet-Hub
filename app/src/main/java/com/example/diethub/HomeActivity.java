package com.example.diethub;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;

import com.example.diethub.Adapters.AdapterForSilder;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,ViewPager.OnPageChangeListener{
    ViewPager viewPager;
    LinearLayout layout;
    DrawerLayout drawer;
    List<Integer> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new
                ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open
                , R.string.navigation_drawer_close);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu);
        viewPager = findViewById(R.id.ViewPager);
        list = new ArrayList<>();
        list.add(R.drawable.diet);
        list.add(R.drawable.diet);
        list.add(R.drawable.diet);
        viewPager.setAdapter(new AdapterForSilder(list,this));

        layout = findViewById(R.id.Points);
        setPoints(0);
        viewPager.setOnPageChangeListener(this);
        getWindow().getDecorView().setSystemUiVisibility
                (View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR |
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

    }

    private void setPoints(int position){
        if (layout.getChildCount() > 0){
            layout.removeAllViews();
        }
        ImageView imageView[] = new ImageView[list.size()];
        for (int i = 0;i < list.size();i++){
            imageView[i] = new ImageView(this);
            if (i == position)
                imageView[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.point_selected));
            else
                imageView[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.point_nono_selected));
            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(5,0,5,0);
            layout.addView(imageView[i],params);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawer.closeDrawer(GravityCompat.START);
        int itemId = item.getItemId();
        if (itemId == R.id.myAccount)
            startActivity(new Intent(this,Account_Activity.class));
        else if (itemId == R.id.myOrders)
            startActivity(new Intent(this,Orders_Activity.class));
        else if (itemId == R.id.listOrder)
            startActivity(new Intent(this, ListOrderActivity2.class));
        return false;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setPoints(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void onClick(View view) {
        int itemId = view.getId();
        if (itemId == R.id.nav_myAccount)
            startActivity(new Intent(this,Account_Activity.class));
        else if (itemId == R.id.nav_myOrders)
            startActivity(new Intent(this,Orders_Activity.class));
        else if (itemId == R.id.nav_listOrder)
            startActivity(new Intent(this, ListOrderActivity2.class));
        else if (itemId == R.id.nav_favorite)
            startActivity(new Intent(this, FavoriteActivity.class));
        else if (itemId == R.id.nav_packages)
            startActivity(new Intent(this, PackagesActivity.class));
        else if (itemId == R.id.nav_notifications)
            startActivity(new Intent(this, Notification_Activity.class));
        else if (itemId == R.id.nav_Consulting)
            startActivity(new Intent(this, Nutritional_CounselingActivity.class));
        else if (itemId == R.id.nav_about)
            startActivity(new Intent(this, AboutUs_Activity.class));
        else if (itemId == R.id.nav_privacy)
            startActivity(new Intent(this, Conditions_Activity.class));
        else if (itemId == R.id.nav_contact_us)
            startActivity(new Intent(this, ConnectWUActivity.class));
        else if (itemId == R.id.nav_langu)
            startActivity(new Intent(this, LanguageActivity.class));
        else if (itemId == R.id.FoodSuppLayout || itemId == R.id.ResLayout)
            startActivity(new Intent(this,RestaurantsActivity.class));
    }
}
