package com.example.diethub.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diethub.R;

import java.util.List;

public class AdapterOfWallet extends RecyclerView.Adapter<AdapterOfWallet.ViewHolderWallet> {
    List<String> list;
    Context context;

    public AdapterOfWallet(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderWallet onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderWallet(LayoutInflater.from(context).inflate(R.layout.model_of_wallet,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderWallet holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolderWallet extends RecyclerView.ViewHolder {

        public ViewHolderWallet(@NonNull View itemView) {
            super(itemView);
        }
    }
}
