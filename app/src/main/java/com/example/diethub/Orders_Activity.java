package com.example.diethub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.diethub.Adapters.AdapterForOrder;
import com.example.diethub.Adapters.AdapterOfOrder;

import java.util.ArrayList;
import java.util.List;

public class Orders_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    public static int conut = 0;
    public static int conut2 = 0;
    public static boolean b1 = false;
    public static boolean b2 = false;
    public static boolean b3 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new AdapterForOrder(getData(),this,0));
        getWindow().getDecorView().setSystemUiVisibility
                (View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR |
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }


    private List<String> getData(){
        List<String> list = new ArrayList<>();
        list.clear();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        return list;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.linearLayout9) {
            recyclerView.setAdapter(new AdapterForOrder(getData(), this, 0));
        }
        else if (view.getId() == R.id.linearLayout10) {
            if (b3)
                recyclerView.setAdapter(new AdapterForOrder(getData(), this, 3));
            else if (!b2)
                recyclerView.setAdapter(new AdapterForOrder(getData(), this, 1));
        }else if (view.getId() == R.id.ProcessingLayout) {
            if (!b3)
                recyclerView.setAdapter(new AdapterForOrder(getData(), this, 2));
        }
    }
}
