package com.example.diethub.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diethub.R;

import java.util.List;

public class AdapterForSlider extends RecyclerView.Adapter<AdapterForSlider.ViewHolderForSlider> {
    List<Integer> list;
    Context context;

    public AdapterForSlider(List<Integer> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderForSlider onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.model_image,parent,false);
        return new ViewHolderForSlider(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderForSlider holder, int position) {
        holder.imageView.setImageResource(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolderForSlider extends RecyclerView.ViewHolder {
        ImageView imageView;
//        ImageView Icon;
//        TextView Title,Description;
        public ViewHolderForSlider(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSlider);
//            Icon = itemView.findViewById(R.id.Icon);
//            Title = itemView.findViewById(R.id.Title);
//            Description = itemView.findViewById(R.id.description);
        }
    }
}
