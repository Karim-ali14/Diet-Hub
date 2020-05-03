package com.example.diethub;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.diethub.Adapters.AdapterOfOrder;
import com.example.diethub.Models.ModelOfOrder;

import java.util.ArrayList;
import java.util.List;

public class ListOrderActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayout Add_Code,Change_Payment_method,Change_Address;
    Button ExecutingRequest,Cancelling_Order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_order);

        Toolbar toolbar = findViewById(R.id.toolbar);
        Add_Code = findViewById(R.id.Add_Code);
        Change_Payment_method = findViewById(R.id.Change_Payment_method);
        ExecutingRequest = findViewById(R.id.ExecutingRequest);
        Cancelling_Order = findViewById(R.id.Cancelling_Order);
        Change_Address = findViewById(R.id.Change_Address);
        Add_Code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListOrderActivity.this,Enter_Discount_CodeActivity.class));
            }
        });
        Change_Payment_method.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListOrderActivity.this,Choose_Payment_WaysActivity.class));
            }
        });
        Change_Address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListOrderActivity.this,Delivery_AddressesActivity.class));
            }
        });
        ExecutingRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListOrderActivity.this,Response_TimeActivity.class));
            }
        });
        Cancelling_Order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCancelingDialog();
            }
        });

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

    private void showCancelingDialog() {
        final AlertDialog.Builder Adialog = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_cancel, null);
        ImageView Image = view.findViewById(R.id.imageView15);
        Image.setImageResource(R.drawable.canclepop);
        TextView Massage = view.findViewById(R.id.Massage);
        Button ButtonSure = view.findViewById(R.id.ButtonSure);
        Button ButtonCancel = view.findViewById(R.id.ButtonCancel);
        Adialog.setView(view);
        Massage.setText(getResources().getString(R.string.Do_Cancel_Order));
        ButtonSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListOrderActivity.this,RestaurantsActivity.class));
            }
        });
        final AlertDialog dialog1 = Adialog.create();
        dialog1.setCanceledOnTouchOutside(false);
        dialog1.setCancelable(false);
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog1.show();
        ButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            dialog1.dismiss();
            }
        });
    }

}