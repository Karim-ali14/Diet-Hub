package com.example.diethub;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Add_AddressesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__addresses);
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
        Adialog.setView(view);
        Massage.setText("تم إضافة العنوان بنجاح");
        ButtonText.setText("تسجيل دخول");
        final AlertDialog dialog1 = Adialog.create();
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog1.show();
    }
}
