package com.example.diethub.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diethub.Orders_Activity;
import com.example.diethub.PrograssBarAnimation;
import com.example.diethub.R;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AdapterForOrder extends RecyclerView.Adapter<AdapterForOrder.ViewHolderForOrders> {
    List<String> list;
    Context context;
    int i ;
    public AdapterForOrder(List<String> list, Context context, int i) {
        this.list = list;
        this.context = context;
        this.i = i;
    }

    @NonNull
    @Override
    public ViewHolderForOrders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderForOrders(LayoutInflater.from(context).inflate(R.layout.model_order,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderForOrders holder, int position) {
        holder.progressBar.setProgress(100);
        holder.iconP.setImageResource(R.drawable.ic_check_black_check);
        holder.iconP.setBackground(context.getResources().getDrawable(R.drawable.style_check));
        if (i == 0 && Orders_Activity.b2){
            holder.OrderButton.setVisibility(View.GONE);
            proceesDE(holder.progressBar2);
            holder.iconPreparing.setImageResource(R.drawable.ic_check_black_normal);
            holder.iconPreparing.setBackground(context.getResources().getDrawable(R.drawable.style_normal));
            if (list.size() -1 == position){
                Orders_Activity.b2 = false;
            }
        }else if (i == 1) {
            holder.OrderButton.setVisibility(View.VISIBLE);
            holder.OrderButton.setText("راسل المندوب");
            holder.progressBar.setProgress(100);
            holder.iconPreparing.setImageResource(R.drawable.ic_check_black_check);
            holder.iconPreparing.setBackground(context.getResources().getDrawable(R.drawable.style_check));
            proceesIN(holder.progressBar2);
            holder.progressBar.setProgress(100);
            holder.finishIcon.setImageResource(R.drawable.ic_check_black_normal);
            holder.finishIcon.setBackground(context.getResources().getDrawable(R.drawable.style_normal));
            if (list.size() -1 == position) {
                Orders_Activity.b2 = true;
            }
            if (Orders_Activity.b3) {
                holder.finishIcon.setBackground(context.getResources().getDrawable(R.drawable.style_normal));
                holder.finishIcon.setImageResource(R.drawable.ic_check_black_normal);
                if (list.size() -1 == position)
                    Orders_Activity.b3 = false;
            }
        }else if (i == 2){
            holder.OrderButton.setVisibility(View.VISIBLE);
            holder.OrderButton.setText("اضف تقييمك");
            if (!Orders_Activity.b2 && !Orders_Activity.b3){
                holder.progressBar.setProgress(100);
                holder.iconPreparing.setImageResource(R.drawable.ic_check_black_check);
                holder.iconPreparing.setBackground(context.getResources().getDrawable(R.drawable.style_check));
                proceesIN(holder.progressBar2);
                holder.progressBar.setProgress(100);
                holder.finishIcon.setBackground(context.getResources().getDrawable(R.drawable.style_check));
                holder.finishIcon.setImageResource(R.drawable.ic_check_black_check);
                if (list.size() -1 == position) {
                    Orders_Activity.b3 = true;
                    Orders_Activity.b2 = true;
                }
            }else if (!Orders_Activity.b3){
                holder.progressBar2.setProgress(100);
                holder.iconPreparing.setImageResource(R.drawable.ic_check_black_check);
                holder.iconPreparing.setBackground(context.getResources().getDrawable(R.drawable.style_check));
                holder.finishIcon.setBackground(context.getResources().getDrawable(R.drawable.style_check));
                holder.finishIcon.setImageResource(R.drawable.ic_check_black_check);
                if (list.size() -1 == position)
                    Orders_Activity.b3 = true;
            }
        }else if (i == 3){
            holder.OrderButton.setVisibility(View.VISIBLE);
            holder.OrderButton.setText("راسل المندوب");
            holder.progressBar2.setProgress(100);
            holder.iconPreparing.setImageResource(R.drawable.ic_check_black_check);
            holder.iconPreparing.setBackground(context.getResources().getDrawable(R.drawable.style_check));
            holder.finishIcon.setBackground(context.getResources().getDrawable(R.drawable.style_normal));
            holder.finishIcon.setImageResource(R.drawable.ic_check_black_normal);
            if (list.size() -1 == position) {
                Orders_Activity.b2 = true;
                Orders_Activity.b3 = false;
            }
        }
    }

    private void proceesIN(final ProgressBar progressBar) {
        PrograssBarAnimation barAnimation = new PrograssBarAnimation(context,progressBar,null,0,100);
        barAnimation.setDuration(700);
        progressBar.setAnimation(barAnimation);
    }

    private void proceesDE(final ProgressBar progressBar) {
        PrograssBarAnimation barAnimation = new PrograssBarAnimation(context,progressBar,null,100,0);
        barAnimation.setDuration(700);
        progressBar.setAnimation(barAnimation);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolderForOrders extends RecyclerView.ViewHolder {
        ProgressBar progressBar,progressBar2;
        ImageView iconP,iconPreparing,finishIcon;
        TextView OrderButton;
        public ViewHolderForOrders(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBar);
            progressBar2 = itemView.findViewById(R.id.progressBar2);
            iconP = itemView.findViewById(R.id.iconP);
            iconPreparing = itemView.findViewById(R.id.iconPreparing);
            finishIcon = itemView.findViewById(R.id.finishIcon);
            OrderButton = itemView.findViewById(R.id.OrderButton);
        }
    }
}
