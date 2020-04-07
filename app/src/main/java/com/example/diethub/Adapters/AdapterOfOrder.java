package com.example.diethub.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diethub.Models.ModelOfOrder;
import com.example.diethub.R;

import java.util.List;

public class AdapterOfOrder extends RecyclerView.Adapter<AdapterOfOrder.ViewHolderOfOrder> {
    List<ModelOfOrder> list;
    Context context;

    public AdapterOfOrder(List<ModelOfOrder> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderOfOrder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderOfOrder(LayoutInflater.from(context)
                .inflate(R.layout.model_of_order,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderOfOrder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolderOfOrder extends RecyclerView.ViewHolder{
        TextView NameOfMeal,DecOfMeal,Number,Price;
        ImageView deleteIcon;
        public ViewHolderOfOrder(@NonNull View itemView) {
            super(itemView);
            NameOfMeal = itemView.findViewById(R.id.NameOfMeal);
            DecOfMeal = itemView.findViewById(R.id.DecOfMeal);
            Number = itemView.findViewById(R.id.Number);
            Price = itemView.findViewById(R.id.Price);
            deleteIcon = itemView.findViewById(R.id.deleteIcon);
        }
    }

}
