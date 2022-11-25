package com.example.hkapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hkapplication.models.CartModel;

import com.example.hkapplication.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    List<CartModel> list ;

    public CartAdapter(List<CartModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CartAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_cart_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        holder.img.setImageResource(list.get(position).getImg());
        holder.name.setText(list.get(position).getName());
        holder.price.setText(list.get(position).getPrice());
        holder.rating.setText(list.get(position).getRating());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name, rating, price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.cart_img);
            name = itemView.findViewById(R.id.cart_item_name);
            rating = itemView.findViewById(R.id.cart_item_rating);
            price = itemView.findViewById(R.id.cart_item_price);

        }
    }
}
