package com.example.diethub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import com.example.diethub.Adapters.AdapterForNameOfDay;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.ArrayList;
import java.util.List;

public class Time_AllocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time__allocation);
        getWindow().getDecorView().setSystemUiVisibility
                (View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR |
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    public void BackButton(View view) {
        finish();
    }

    public void onClick(View view) {
        final BottomSheetDialog dialog = new BottomSheetDialog(this,R.style.BottomSheetDialogTheme);
        View bottomSheet = LayoutInflater.from(this).inflate(R.layout.dialgo_select_time
                ,(RelativeLayout)findViewById(R.id.container));

        dialog.setContentView(bottomSheet);
        dialog.show();

        RecyclerView recyclerView = bottomSheet.findViewById(R.id.Recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(new AdapterForNameOfDay(getData(),this));
        recyclerView.smoothScrollToPosition(0);
        NumberPicker Hour = bottomSheet.findViewById(R.id.Hour);
        NumberPicker Minutes = bottomSheet.findViewById(R.id.Minutes);
        Hour.setMaxValue(12);
        Hour.setMinValue(1);
        Minutes.setMaxValue(60);
        Minutes.setMinValue(00);
    }

    private List<String> getData() {
        List<String> list = new ArrayList<>();
        list.add("السبت");
        list.add("الأحد");
        list.add("الأثنين");
        list.add("الثلاثاء");
        list.add("الأربعاء");
        list.add("الخميس");
        list.add("الجمعه");
        return list;
    }
}
