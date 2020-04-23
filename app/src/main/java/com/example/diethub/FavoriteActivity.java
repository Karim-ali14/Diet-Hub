package com.example.diethub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.diethub.Adapters.AdapterForMenu;
import com.example.diethub.Adapters.AdapterForRestaurants;
import com.example.diethub.Models.DataOfMenu;
import com.example.diethub.Models.DataOfRestaurants;

import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView Meals,Restaurants;
    LinearLayout MealsLayout,RestaurantLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        init();
    }

    private void init(){
        getWindow().getDecorView().setSystemUiVisibility
                (View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR |
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        recyclerView = findViewById(R.id.Recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new AdapterForMenu(getDataMeals(),this,1));

        Meals = findViewById(R.id.Meals);
        Restaurants = findViewById(R.id.Restaurants);
        MealsLayout = findViewById(R.id.MealsLayout);
        RestaurantLayout = findViewById(R.id.RestaurantLayout);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.MealsLayout){
            MealsLayout.setBackground(getResources().getDrawable(R.drawable.s_bb));
            Meals.setTextColor(getResources().getColor(R.color.white));

            RestaurantLayout.setBackground(getResources().getDrawable(R.drawable.s_bb2));
            Restaurants.setTextColor(getResources().getColor(R.color.colorPrimary));

            recyclerView.setAdapter(new AdapterForMenu(getDataMeals(),this,1));
        }else if (id == R.id.RestaurantLayout){
            RestaurantLayout.setBackground(getResources().getDrawable(R.drawable.s_bb));
            Restaurants.setTextColor(getResources().getColor(R.color.white));

            MealsLayout.setBackground(getResources().getDrawable(R.drawable.s_bb2));
            Meals.setTextColor(getResources().getColor(R.color.colorPrimary));

            recyclerView.setAdapter(new AdapterForRestaurants(getDateRes(),this,1));
        }
    }

    public List<DataOfMenu> getDataMeals(){

        List<DataOfMenu> list = new ArrayList<>();
        list.clear();
        list.add(new DataOfMenu("وجية فراخ مشوية","خليط من صدور واوراك الفراخ المشوية علي الفخم التومية + سلطات وعيش سوري",
                "3.5","1","25",R.drawable.mmmmm));
        list.add(new DataOfMenu("لحم بصوص الجريفي","خليط من صدور واوراك الفراخ المشوية علي الفخم التومية + سلطات وعيش سوري",
                "5","1","25",R.drawable.mmmmm));
        list.add(new DataOfMenu("كبسة الدجاج","خليط من صدور واوراك الفراخ المشوية علي الفخم التومية + سلطات وعيش سوري",
                "2.5","1","25",R.drawable.mmmmm));
        return list;
    }

    private List<DataOfRestaurants> getDateRes(){
        List<DataOfRestaurants> list = new ArrayList<>();
        list.clear();
        list.add(new DataOfRestaurants("مطاعم ليمونة","سلسلة مطاعم ليمونه للاكل الشرقي","4.0","2",R.drawable.lamon,true));
        list.add(new DataOfRestaurants("مطاعم دايت ورلد","سلسلة مطاعم ليمونه للاكل الشرقي","5","2",R.drawable.world,false));
        list.add(new DataOfRestaurants("مطاعم دايت ديش","سلسلة مطاعم ليمونه للاكل الشرقي","2.5","3",R.drawable.dich,false));
        return list;
    }
}
