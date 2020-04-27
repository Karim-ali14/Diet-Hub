package com.example.diethub.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diethub.R;

import java.util.List;

public class AdapterForRating extends RecyclerView.Adapter<AdapterForRating.ViewHolderForRating> {
    List<String> list;
    Context context;

    public AdapterForRating(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderForRating onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderForRating(LayoutInflater.from(context)
                .inflate(R.layout.model_rating,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderForRating holder, int position) {
        holder.flagIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder Adialog = new AlertDialog.Builder(context);
                View view = LayoutInflater.from(context).inflate(R.layout.dialog_ration, null);
                CardView Container = view.findViewById(R.id.Container);
                Adialog.setView(view);
                final AlertDialog dialog1 = Adialog.create();
                dialog1.setCanceledOnTouchOutside(false);
                dialog1.setCancelable(false);
                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog1.show();
                Container.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog1.dismiss();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderForRating extends RecyclerView.ViewHolder {
        ImageView flagIcon;
        public ViewHolderForRating(@NonNull View itemView) {
            super(itemView);
            flagIcon = itemView.findViewById(R.id.flagIcon);
        }
    }
}
