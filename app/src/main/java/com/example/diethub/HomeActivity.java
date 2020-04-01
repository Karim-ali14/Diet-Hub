package com.example.diethub;

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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,ViewPager.OnPageChangeListener{
    ViewPager viewPager;
    DrawerLayout drawer;
    LinearLayout layout;
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

        viewPager = findViewById(R.id.ViewPager);
        list = new ArrayList<>();
        list.add(R.drawable.side_nav_bar);
        list.add(R.drawable.side_nav_bar);
        list.add(R.drawable.side_nav_bar);
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
        Toast.makeText(this, "selected", Toast.LENGTH_SHORT).show();
        drawer.closeDrawer(GravityCompat.START);
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
}
