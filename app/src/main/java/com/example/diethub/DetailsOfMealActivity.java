package com.example.diethub;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    TextView Count;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_meal);

        viewPager = findViewById(R.id.ViewPager);
        Count = findViewById(R.id.Count);
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
        if (view.getId() == R.id.favoriteIcon){
            dialogForFavorite();
        }else if (view.getId() == R.id.ListIcon)
            startActivity(new Intent(this, ListOrderActivity.class));
        else if (view.getId() == R.id.CaloriesLayout)
            dialogForCalories();
        else if (view.getId() == R.id.Decrement){
            if (i > 0) {
                Count.setText(--i + "");
            }
        }
        else if (view.getId() == R.id.Increment){
            Count.setText(++i+"");
        }
    }

    private void dialogForFavorite(){
        final AlertDialog.Builder Adialog = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_favorite, null);
        Button ContainerButton = view.findViewById(R.id.ContainerButton);
        Adialog.setView(view);
        final AlertDialog dialog1 = Adialog.create();
        dialog1.setCanceledOnTouchOutside(false);
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog1.show();
        ContainerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailsOfMealActivity.this,FavoriteActivity.class));
            }
        });
    }

    private void dialogForCalories(){
        final AlertDialog.Builder Adialog = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_calories, null);
        ImageView closeIcon = view.findViewById(R.id.closeIcon);
        Adialog.setView(view);
        final AlertDialog dialog1 = Adialog.create();
        dialog1.setCanceledOnTouchOutside(false);
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
