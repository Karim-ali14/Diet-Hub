package com.example.diethub.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diethub.Models.ModelOfAdds;
import com.example.diethub.R;

import java.util.List;

public class AdapterOfAdds extends RecyclerView.Adapter<AdapterOfAdds.ViewHolderOfAdds> {
    List<ModelOfAdds> list;
    Context context;

    public AdapterOfAdds(List<ModelOfAdds> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderOfAdds onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderOfAdds(LayoutInflater.from(context)
                .inflate(R.layout.models_adds,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderOfAdds holder, int position) {
        if (list.size()-1 == position)
            holder.Line.setVisibility(View.GONE);
        else
            holder.Line.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolderOfAdds extends RecyclerView.ViewHolder{
        CheckBox checkBox;
        TextView Name,Dec,Price;
        View Line;
        public ViewHolderOfAdds(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkBox);
            Name = itemView.findViewById(R.id.NameOfAdds);
            Dec = itemView.findViewById(R.id.DecOfAdds);
            Price = itemView.findViewById(R.id.Price);
            Line = itemView.findViewById(R.id.Line);
        }
    }
}
