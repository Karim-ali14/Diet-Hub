package com.example.diethub.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diethub.R;

import java.util.List;

public class AdapterForPackage extends RecyclerView.Adapter<AdapterForPackage.ViewHolderForPackage> {
    List<String> list;
    Context context;

    public AdapterForPackage(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderForPackage onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderForPackage(LayoutInflater.from(context).inflate(R.layout.model_package,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderForPackage holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolderForPackage extends RecyclerView.ViewHolder {
        public ViewHolderForPackage(@NonNull View itemView) {
            super(itemView);
        }
    }
}
