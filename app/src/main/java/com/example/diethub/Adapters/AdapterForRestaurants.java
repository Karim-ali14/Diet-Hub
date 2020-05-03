package com.example.diethub.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diethub.DetailsOfMealActivity;
import com.example.diethub.FavoriteActivity;
import com.example.diethub.MenuOfResturantsActivity;
import com.example.diethub.Models.DataOfRestaurants;
import com.example.diethub.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterForRestaurants extends RecyclerView.Adapter<AdapterForRestaurants.ViewHolderForRes> {

    List<DataOfRestaurants> list;
    Context context;
    int type;

    public AdapterForRestaurants(List<DataOfRestaurants> list, Context context, int type) {
        this.list = list;
        this.context = context;
        this.type = type;
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
        if (data.isIsfree())
            holder.isFree.setVisibility(View.VISIBLE);
        else
            holder.isFree.setVisibility(View.GONE);

        if (type == 0)
            holder.favoriteIcon.setImageResource(R.drawable.favegreen);
        else if (type == 1)
            holder.favoriteIcon.setImageResource(R.drawable.itemfullfave);
        holder.favoriteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogForFavorite();
            }
        });
    }
    private void dialogForFavorite(){
        final AlertDialog.Builder Adialog = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_favorite, null);
        Button ContainerButton = view.findViewById(R.id.ContainerButton);
        Adialog.setView(view);
        final AlertDialog dialog1 = Adialog.create();
        dialog1.setCanceledOnTouchOutside(true);
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog1.show();
        ContainerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, FavoriteActivity.class));
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
        public ImageView Icon,isFree,favoriteIcon;
        public ViewHolderForRes(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.NameOfRes);
            des = itemView.findViewById(R.id.Dec);
            numOfRating = itemView.findViewById(R.id.NumberOfRating);
            rating = itemView.findViewById(R.id.Rating);
            Icon = itemView.findViewById(R.id.IconOfRes);
            isFree = itemView.findViewById(R.id.isFree);
            cardView = itemView.findViewById(R.id.CardView);
            favoriteIcon = itemView.findViewById(R.id.favoriteIcon);
        }
    }
}
