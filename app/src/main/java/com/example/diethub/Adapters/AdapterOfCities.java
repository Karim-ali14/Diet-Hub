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

public class AdapterOfCities extends RecyclerView.Adapter<AdapterOfCities.ViewHolderOfCities> {
    List<String> list;
    Context context;

    public AdapterOfCities(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderOfCities onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderOfCities(LayoutInflater.from(context)
                .inflate(R.layout.model_city,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderOfCities holder, int position) {
        holder.cityName.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderOfCities extends RecyclerView.ViewHolder {
        TextView cityName;
        public ViewHolderOfCities(@NonNull View itemView) {
            super(itemView);
            cityName = itemView.findViewById(R.id.NameOfCity);
        }
    }
}
