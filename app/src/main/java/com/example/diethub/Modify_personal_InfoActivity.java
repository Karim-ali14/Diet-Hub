package com.example.diethub;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.diethub.Adapters.AdapterOfCities;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class Modify_personal_InfoActivity extends AppCompatActivity {
    EditText UserName,Phone,Email;
    ConstraintLayout Layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_personal__info);
        init();
    }
    private void init(){
        getWindow().getDecorView().setSystemUiVisibility
                (View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR |
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        UserName = findViewById(R.id.UserName);
        Phone = findViewById(R.id.PhoneNumber);
        Email = findViewById(R.id.Email);
        Layout = findViewById(R.id.Layout);
        Layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (!(v instanceof EditText))
                    closeKeyBoard();
                return false;
            }
        });

    }

    private void closeKeyBoard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(this.getWindow().getDecorView().getRootView().getWindowToken(), 0);
        UserName.clearFocus();
        Phone.clearFocus();
        Email.clearFocus();
    }

    public void BackButton(View view) {
        finish();
    }

    public void onClick(View view1) {
        final BottomSheetDialog dialog = new BottomSheetDialog(this,R.style.BottomSheetDialogTheme);
        View bottomSheet = LayoutInflater.from(this).inflate(R.layout.dialog_choose_city
                ,(RelativeLayout)findViewById(R.id.container));

        dialog.setContentView(bottomSheet);
        dialog.show();
        RecyclerView recyclerView = bottomSheet.findViewById(R.id.Recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AdapterOfCities(getData(),this));
    }

    private List<String> getData() {
        List<String> list = new ArrayList<>();
        list.add("مكة المكرمه");
        list.add("مكة المكرمه");
        list.add("مكة المكرمه");
        list.add("مكة المكرمه");
        list.add("مكة المكرمه");

        return list;
    }
}
