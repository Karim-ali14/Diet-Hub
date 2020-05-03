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
import android.widget.LinearLayout;
import android.widget.TextView;

public class Registration_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_);
        getWindow().getDecorView().setSystemUiVisibility
                (View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR |
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    public void onClick(View view1) {

        if (view1.getId() == R.id.conditions){
            startActivity(new Intent(Registration_Activity.this,Conditions_Activity.class));
        }else if (view1.getId() == R.id.EnterButton){
            showSuccessDialog();
        }

    }

    private void showSuccessDialog() {
        final AlertDialog.Builder Adialog = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_registraion_success, null);
        TextView Massage = view.findViewById(R.id.Massage);
        Button LoginButton = view.findViewById(R.id.LoginButton);
        Adialog.setView(view);
        Massage.setText(getResources().getString(R.string.Account_Created_Successfully));
        LoginButton.setText(getResources().getString(R.string.Login));
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration_Activity.this,Login_inActivity.class));
            }
        });
        final AlertDialog dialog1 = Adialog.create();
        dialog1.setCanceledOnTouchOutside(false);
        dialog1.setCancelable(false);
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog1.show();
    }

}
