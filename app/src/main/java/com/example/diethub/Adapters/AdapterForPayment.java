package com.example.diethub.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diethub.R;

import java.util.List;

public class AdapterForPayment extends RecyclerView.Adapter<AdapterForPayment.ViewHolderForPayment> {
    List<String> list;
    Context context;

    public AdapterForPayment(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderForPayment onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderForPayment(LayoutInflater.from(context).inflate(R.layout.model_payment,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderForPayment holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolderForPayment extends RecyclerView.ViewHolder {
        public ViewHolderForPayment(@NonNull View itemView) {
            super(itemView);
        }
    }
}
