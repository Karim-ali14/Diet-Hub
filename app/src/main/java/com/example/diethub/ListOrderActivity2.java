package com.example.diethub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.diethub.Adapters.AdapterOfOrder;
import com.example.diethub.Models.ModelOfOrder;

import java.util.ArrayList;
import java.util.List;

public class ListOrderActivity2 extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_order);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AdapterOfOrder(getData(),this));
        getWindow().getDecorView().setSystemUiVisibility
                (View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR |
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    private List<ModelOfOrder> getData(){
        List<ModelOfOrder> list = new ArrayList<>();
        list.add(new ModelOfOrder("","","",""));
        list.add(new ModelOfOrder("","","",""));
        list.add(new ModelOfOrder("","","",""));

        return list;
    }

    public void BackButton(View view) {
        finish();
    }
}