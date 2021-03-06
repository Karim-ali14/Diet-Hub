package com.example.diethub.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
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
import com.example.diethub.Models.DataOfMenu;
import com.example.diethub.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterForMenu extends RecyclerView.Adapter<AdapterForMenu.ViewHolderForMenu> {
    List<DataOfMenu> list;
    Context context;
    int type;

    public AdapterForMenu(List<DataOfMenu> list, Context context, int type) {
        this.list = list;
        this.context = context;
        this.type = type;
    }

    @NonNull
    @Override
    public ViewHolderForMenu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.model_menu,parent,false);
        return new ViewHolderForMenu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderForMenu holder, int position) {
        DataOfMenu data = list.get(position);
        Log.i("TTTTTT",data.getName());
        holder.NameOfFood.setText(data.getName());
        holder.DecOFFood.setText(data.getDec());
        holder.NumOfRating.setText(data.getRating());
        holder.Price.setText(data.getPrice());
        Picasso.with(context).load(data.getIcon()).into(holder.Icon);
        holder.text1.setPaintFlags(holder.text1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        holder.text2.setPaintFlags(holder.text2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailsOfMealActivity.class));
            }
        });
        if (type == 0)
            holder.favoriteIcon.setImageResource(R.drawable.addfavegreen);
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

    public class ViewHolderForMenu extends RecyclerView.ViewHolder {
        public TextView NameOfFood,DecOFFood,NumOfRating,Price,text1,text2;
        public ImageView rating;
        public CardView cardView;
        public ImageView Icon,favoriteIcon;
        public ViewHolderForMenu(@NonNull View itemView) {
            super(itemView);
            NameOfFood = itemView.findViewById(R.id.NameOfFood);
            Price = itemView.findViewById(R.id.Price);
            DecOFFood = itemView.findViewById(R.id.DecOfFood);
            NumOfRating = itemView.findViewById(R.id.NumberOfRatingOfFood);
            rating = itemView.findViewById(R.id.RatingOfFood);
            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
            cardView = itemView.findViewById(R.id.CardViewOfMenu);
            Icon = itemView.findViewById(R.id.IconOfFood);
            favoriteIcon = itemView.findViewById(R.id.favoriteIcon);
        }
    }
}
