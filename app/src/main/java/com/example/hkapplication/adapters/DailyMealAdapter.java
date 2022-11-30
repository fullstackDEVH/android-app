package com.example.hkapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hkapplication.R;
import com.example.hkapplication.activities.DetailDailyMealActivity;
import com.example.hkapplication.models.DailyModel;

import java.util.List;

public class DailyMealAdapter extends RecyclerView.Adapter<DailyMealAdapter.ViewHolder> {
    Context context;
    List<DailyModel> list;

    public DailyMealAdapter(Context context, List<DailyModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DailyMealAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DailyMealAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_meal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DailyMealAdapter.ViewHolder holder, int position) {
        holder.img.setImageResource(list.get(position).getImg());
        holder.name.setText(list.get(position).getName());
        holder.desc.setText(list.get(position).getDesc());
        holder.discount.setText(list.get(position).getDiscount());
        int newPo = position;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, ""+list.get(newPo).getType(), Toast.LENGTH_SHORT).show();
                Intent in = new Intent(context, DetailDailyMealActivity.class);
                in.putExtra("type", list.get(newPo).getType());
                context.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name, desc, discount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.daily_item_img);
            name = itemView.findViewById(R.id.daily_item_name);
            desc = itemView.findViewById(R.id.daily_item_desc);
            discount = itemView.findViewById(R.id.daily_item_discount);

        }
    }
}
