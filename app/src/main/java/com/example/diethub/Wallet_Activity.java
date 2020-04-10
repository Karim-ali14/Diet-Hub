package com.example.diethub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.diethub.Adapters.AdapterOfOrder;
import com.example.diethub.Adapters.AdapterOfWallet;

import java.util.ArrayList;
import java.util.List;

public class Wallet_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AdapterOfWallet(getData(),this));
    }

    private List<String> getData(){
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        return list;
    }

    public void BackButton(View view) {
        finish();
    }
}
