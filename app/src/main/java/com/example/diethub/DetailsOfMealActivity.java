package com.example.diethub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.diethub.Adapters.AdapterForSilder;
import com.example.diethub.Adapters.AdapterOfAdds;
import com.example.diethub.Models.ModelOfAdds;

import java.util.ArrayList;
import java.util.List;

public class DetailsOfMealActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    ViewPager viewPager;
    LinearLayout layout;
    List<Integer> list;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_meal);

        viewPager = findViewById(R.id.ViewPager);
        list = new ArrayList<>();
        list.add(R.drawable.gggggg);
        list.add(R.drawable.diet);
        list.add(R.drawable.dd);
        viewPager.setAdapter(new AdapterForSilder(list,this));

        layout = findViewById(R.id.Points);
        setPoints(0);
        viewPager.setOnPageChangeListener(this);
        getWindow().getDecorView().setSystemUiVisibility
                (View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR |
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        recyclerView = findViewById(R.id.RecyclerOfAdds);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        List<ModelOfAdds> list = new ArrayList<>();
        list.add(new ModelOfAdds(false,"","",""));
        list.add(new ModelOfAdds(false,"","",""));
        list.add(new ModelOfAdds(false,"","",""));
        list.add(new ModelOfAdds(false,"","",""));
        recyclerView.setAdapter(new AdapterOfAdds(list,this));
    }

    public void BackButton(View view) {
        finish();
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
                imageView[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.point_nono_selected2));
            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(5,0,5,0);
            layout.addView(imageView[i],params);
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

    public void onClick(View view) {
        startActivity(new Intent(this,ListOrderActivity2.class));
    }
}
