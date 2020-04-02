package com.example.diethub.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diethub.MenuOfResturantsActivity;
import com.example.diethub.Models.DataOfRestaurants;
import com.example.diethub.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterForRestaurants extends RecyclerView.Adapter<AdapterForRestaurants.ViewHolderForRes> {

    List<DataOfRestaurants> list;
    Context context;

    public AdapterForRestaurants(List<DataOfRestaurants> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderForRes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.model_restaurant,parent,false);
        return new ViewHolderForRes(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderForRes holder, int position) {
        final DataOfRestaurants data = list.get(position);
        holder.name.setText(data.getName());
        holder.des.setText(data.getDec());
        holder.numOfRating.setText(data.getRating());
        holder.rating.setRating(Float.parseFloat(data.getRating()));
        Picasso.with(context).load(data.getIcon()).into(holder.Icon);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, MenuOfResturantsActivity.class)
                        .putExtra("MenuId",data));
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderForRes extends RecyclerView.ViewHolder {
        public TextView name,des,numOfRating;
        public RatingBar rating;
        public CardView cardView;
        public ImageView Icon;
        public ViewHolderForRes(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.NameOfRes);
            des = itemView.findViewById(R.id.Dec);
            numOfRating = itemView.findViewById(R.id.NumberOfRating);
            rating = itemView.findViewById(R.id.Rating);
            Icon = itemView.findViewById(R.id.IconOfRes);
            cardView = itemView.findViewById(R.id.CardView);
        }
    }
}
