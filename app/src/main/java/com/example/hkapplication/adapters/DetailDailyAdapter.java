package com.example.hkapplication.adapters;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hkapplication.R;
import com.example.hkapplication.models.DetailDailyModel;

import java.util.List;

public class DetailDailyAdapter extends RecyclerView.Adapter<DetailDailyAdapter.ViewHolder> {

    List<DetailDailyModel> list ;

    public DetailDailyAdapter(List<DetailDailyModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public DetailDailyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DetailDailyAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_daily_meal_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull DetailDailyAdapter.ViewHolder holder, int position) {
        holder.img.setImageResource(list.get(position).getImg());
        holder.name.setText(list.get(position).getName());
        holder.desc.setText(list.get(position).getDesc());
        holder.time.setText(list.get(position).getTime());
        holder.price.setText(list.get(position).getPrice());
        holder.rating.setText(list.get(position).getRating());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name, price, desc, rating, time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.daily_detail_img);
            name = itemView.findViewById(R.id.daily_detail_name);
            price = itemView.findViewById(R.id.daily_detail_price);
            desc = itemView.findViewById(R.id.daily_detail_desc);
            rating = itemView.findViewById(R.id.daily_detail_rating);
            time = itemView.findViewById(R.id.daily_detail_time);
        }
    }
}
