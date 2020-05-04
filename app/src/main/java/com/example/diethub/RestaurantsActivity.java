package com.example.diethub;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.diethub.Adapters.AdapterForRestaurants;
import com.example.diethub.Adapters.AdapterForSilder;
import com.example.diethub.Models.DataOfRestaurants;

import java.util.ArrayList;
import java.util.List;

public class RestaurantsActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    ViewPager viewPager;
    LinearLayout points;
    List<Integer> list;
    RecyclerView Recycler;
    ConstraintLayout Search_layout,Layout;
    ImageView searchIcon,closeIcon;
    EditText search_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        viewPager = findViewById(R.id.viewPager);
        points = findViewById(R.id.points);
        Search_layout = findViewById(R.id.Search_layout);
        Layout = findViewById(R.id.Layout);
        searchIcon = findViewById(R.id.searchIcon);
        closeIcon = findViewById(R.id.closeIcon);
        search_bar = findViewById(R.id.search_bar);
        search_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_bar.setText("");
            }
        });
        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Search_layout.setVisibility(View.VISIBLE);
            }
        });
        closeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Search_layout.setVisibility(View.GONE);
            }
        });
        list = new ArrayList<>();
        list.add(R.drawable.dd);
        list.add(R.drawable.uu);
        list.add(R.drawable.diet);
        viewPager.setAdapter(new AdapterForSilder(list,this));
        setPoints(0);
        viewPager.setOnPageChangeListener(this);
        Recycler = findViewById(R.id.Recycler);
        Recycler.setHasFixedSize(true);
        Recycler.setLayoutManager(new LinearLayoutManager(this));
        Recycler.setAdapter(new AdapterForRestaurants(getDate(),this,0));
        getWindow().getDecorView().setSystemUiVisibility
                (View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR |
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        Layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (!(v instanceof EditText))
                    closeKeyBoard();
                return false;
            }
        });
    }

    private void closeKeyBoard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(this.getWindow().getDecorView().getRootView().getWindowToken(), 0);
        search_bar.clearFocus();
    }

    private void setPoints(int position){
        if (points.getChildCount() > 0){
            points.removeAllViews();
        }
        ImageView imageView[] = new ImageView[list.size()];
        for (int i = 0;i < list.size();i++){
            imageView[i] = new ImageView(this);
            if (i == position)
                imageView[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.point_selected));
            else
                imageView[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.point_nono_selected2));
            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(5,0,5,0);
            points.addView(imageView[i],params);
        }

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

    private List<DataOfRestaurants> getDate(){
        List<DataOfRestaurants> list = new ArrayList<>();
        list.add(new DataOfRestaurants("مطاعم ليمونة","سلسلة مطاعم ليمونه للاكل الشرقي","4.0","2",R.drawable.lamon,true));
        list.add(new DataOfRestaurants("مطاعم دايت ورلد","سلسلة مطاعم ليمونه للاكل الشرقي","5","2",R.drawable.world,false));
        list.add(new DataOfRestaurants("مطاعم دايت ديش","سلسلة مطاعم ليمونه للاكل الشرقي","2.5","3",R.drawable.dich,false));
        list.add(new DataOfRestaurants("مطاعم دايت إستيشن","سلسلة مطاعم ليمونه للاكل الشرقي","2.5","4",R.drawable.astashn,false));
        return list;
    }

    public void onClick(View view1) {
        final AlertDialog.Builder Adialog = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_cournt_location, null);
        TextView Address = view.findViewById(R.id.Address);
        ImageView closeIcon = view.findViewById(R.id.closeIcon);
        Adialog.setView(view);
        final AlertDialog dialog1 = Adialog.create();
        dialog1.setCanceledOnTouchOutside(false);
        dialog1.setCancelable(false);
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog1.show();
        closeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
            }
        });
    }
}
