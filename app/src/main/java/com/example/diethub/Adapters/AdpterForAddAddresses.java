package com.example.diethub.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diethub.FavoriteActivity;
import com.example.diethub.R;

import java.util.List;

public class AdpterForAddAddresses extends RecyclerView.Adapter<AdpterForAddAddresses.ViewHolderForAddAddresses> {
    List<String> list;
    Context context;

    public AdpterForAddAddresses(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public AdpterForAddAddresses.ViewHolderForAddAddresses onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdpterForAddAddresses.ViewHolderForAddAddresses(LayoutInflater
                .from(context).inflate(R.layout.model_add_address,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdpterForAddAddresses.ViewHolderForAddAddresses holder, int position) {
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogForFavorite();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolderForAddAddresses extends RecyclerView.ViewHolder {
        ImageView delete;
        public ViewHolderForAddAddresses(@NonNull View itemView) {
            super(itemView);
            delete = itemView.findViewById(R.id.deleteIcon);
        }
    }
    private void dialogForFavorite(){
        final AlertDialog.Builder Adialog = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_cancel, null);
        LinearLayout ContainerButton = view.findViewById(R.id.ContainerButton);
        TextView Massage = view.findViewById(R.id.Massage);
        Massage.setText("هل تريد حذف هذا العنوان ؟");
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
}
