package com.example.diethub.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diethub.R;

import java.util.List;

public class AdapterForNameOfDay extends RecyclerView.Adapter<AdapterForNameOfDay.ViewHolderForNameOfDay> {
    List<String> list;
    Context context;

    public AdapterForNameOfDay(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderForNameOfDay onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderForNameOfDay(LayoutInflater.from(context).inflate(R.layout.model_name_day,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderForNameOfDay holder, int position) {
        holder.NameOfDay.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderForNameOfDay extends RecyclerView.ViewHolder {
        TextView NameOfDay;
        public ViewHolderForNameOfDay(@NonNull View itemView) {
            super(itemView);
            NameOfDay = itemView.findViewById(R.id.NameOfDay);
        }
    }
}
