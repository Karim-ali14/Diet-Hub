package com.example.diethub.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diethub.R;

import java.util.List;

public class AdapterOfAddresses extends RecyclerView.Adapter<AdapterOfAddresses.ViewHolderOfAddresses> {
    List<String> list;
    Context context;

    public AdapterOfAddresses(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderOfAddresses onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderOfAddresses(LayoutInflater.from(context).inflate(R.layout.model_addresses,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderOfAddresses holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolderOfAddresses extends RecyclerView.ViewHolder {
        public ViewHolderOfAddresses(@NonNull View itemView) {
            super(itemView);
        }
    }
}
