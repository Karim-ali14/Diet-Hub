package com.example.diethub.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diethub.R;

import java.util.List;

public class AdapterForNotification extends RecyclerView.Adapter<AdapterForNotification.ViewHolderForNotification> {
    List<String> list;
    Context context;

    public AdapterForNotification(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderForNotification onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderForNotification(LayoutInflater.from(context)
                .inflate(R.layout.model_notification,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderForNotification holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderForNotification extends RecyclerView.ViewHolder {
        public ViewHolderForNotification(@NonNull View itemView) {
            super(itemView);
        }
    }
}
