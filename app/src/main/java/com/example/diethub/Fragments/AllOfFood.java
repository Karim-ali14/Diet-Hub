package com.example.diethub.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diethub.Adapters.AdapterForMenu;
import com.example.diethub.Models.DataOfMenu;
import com.example.diethub.Models.DataOfRestaurants;
import com.example.diethub.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllOfFood extends Fragment {

    DataOfRestaurants data;
    boolean bool;
    public AllOfFood(DataOfRestaurants data,boolean bool) {
        this.data = data;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_food, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.RecyclerForMenu);
        if (bool)

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new AdapterForMenu(getData(),getActivity()));
        return view;
    }
    public List<DataOfMenu> getData(){

        List<DataOfMenu> list = new ArrayList<>();
        list.add(new DataOfMenu("وجية فراخ مشوية","خليط من صدور واوراك الفراخ المشوية علي الفخم التومية + سلطات وعيش سوري",
                "3.5","1","25",R.drawable.chiken));
        list.add(new DataOfMenu("لحم بصوص الجريفي","خليط من صدور واوراك الفراخ المشوية علي الفخم التومية + سلطات وعيش سوري",
                "5","1","25",R.drawable.red_meat_guide));
        list.add(new DataOfMenu("كبسة الدجاج","خليط من صدور واوراك الفراخ المشوية علي الفخم التومية + سلطات وعيش سوري",
                "2.5","1","25",R.drawable.ch2));
        list.add(new DataOfMenu("وجية فراخ مشوية","خليط من صدور واوراك الفراخ المشوية علي الفخم التومية + سلطات وعيش سوري",
                "1","2","25",R.drawable.gggggg));
        list.add(new DataOfMenu("وجية فراخ مشوية","خليط من صدور واوراك الفراخ المشوية علي الفخم التومية + سلطات وعيش سوري",
                "3","3","25",R.drawable.chiken));
        list.add(new DataOfMenu("لحم بصوص الجريفي","خليط من صدور واوراك الفراخ المشوية علي الفخم التومية + سلطات وعيش سوري",
                "2.5","2","25",R.drawable.red_meat_guide));
        list.add(new DataOfMenu("كبسة الدجاج","خليط من صدور واوراك الفراخ المشوية علي الفخم التومية + سلطات وعيش سوري",
                "3.5","3","25",R.drawable.ch2));
        list.add(new DataOfMenu("وجية فراخ مشوية","خليط من صدور واوراك الفراخ المشوية علي الفخم التومية + سلطات وعيش سوري",
                "4.5","2","25",R.drawable.gggggg));

        return list;
    }

}
