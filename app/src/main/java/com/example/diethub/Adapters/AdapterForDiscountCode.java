package com.example.diethub.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diethub.R;

import java.util.List;

public class AdapterForDiscountCode extends RecyclerView.Adapter<AdapterForDiscountCode.ViewHolderForDiscountCode> {
    List<String> list;
    Context context;

    public AdapterForDiscountCode(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderForDiscountCode onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderForDiscountCode(LayoutInflater
                .from(context).inflate(R.layout.model_code,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderForDiscountCode holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderForDiscountCode extends RecyclerView.ViewHolder {
        public ViewHolderForDiscountCode(@NonNull View itemView) {
            super(itemView);
        }
    }
}
