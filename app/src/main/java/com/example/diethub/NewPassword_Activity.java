package com.example.diethub;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewPassword_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password_);
    }

    public void onClick(View view1) {
        final AlertDialog.Builder Adialog = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_registraion_success, null);
        TextView Massage = view.findViewById(R.id.Massage);
        TextView ButtonText = view.findViewById(R.id.ButtonText);
        Adialog.setView(view);
        Massage.setText("تم إسترجاع كلمة المرور بنجاح");
        ButtonText.setText("تسجيل دخول");
        ButtonText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewPassword_Activity.this,Login_inActivity.class));
            }
        });
        final AlertDialog dialog1 = Adialog.create();
        dialog1.setCanceledOnTouchOutside(false);
        dialog1.setCancelable(false);
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog1.show();
    }
}
