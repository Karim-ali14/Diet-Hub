package com.example.diethub;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.diethub.Adapters.AdapterForDiscountCode;

import java.util.ArrayList;
import java.util.List;

public class Enter_Discount_CodeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter__discount__code);
        getWindow().getDecorView().setSystemUiVisibility
                (View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR |
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        recyclerView = findViewById(R.id.Recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new AdapterForDiscountCode(getData(),this));
    }

    private List<String> getData() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");

        return list;
    }

    public void BackButton(View view) {
        finish();
    }

    public void onClick(View view1) {
        final AlertDialog.Builder Adialog = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_registraion_success, null);
        TextView Massage = view.findViewById(R.id.Massage);
        TextView ButtonText = view.findViewById(R.id.ButtonText);
        LinearLayout Button = view.findViewById(R.id.ButtonsLayout);
        Button.setVisibility(View.GONE);
        ButtonText.setVisibility(View.GONE);
        Massage.setText("تم إضافة كود الخصم بنجاح");
        Adialog.setView(view);
        final AlertDialog dialog1 = Adialog.create();
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog1.show();
    }

}
