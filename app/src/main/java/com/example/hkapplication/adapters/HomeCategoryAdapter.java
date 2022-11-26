package com.example.hkapplication.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hkapplication.R;
import com.example.hkapplication.models.HomeCategoryModel;
import com.example.hkapplication.models.HomeProductModel;

import java.util.ArrayList;
import java.util.List;

public class HomeCategoryAdapter extends RecyclerView.Adapter<HomeCategoryAdapter.ViewHolder> {
    SelectedCategory selectedCategory;
    Activity activity;
    ArrayList<HomeCategoryModel> list;

    boolean check = true;
    boolean selected = true;
    int row_index = -1;

    public HomeCategoryAdapter(SelectedCategory selectedCategory, Activity activity, ArrayList<HomeCategoryModel> list) {
        this.selectedCategory = selectedCategory;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public HomeCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeCategoryAdapter.ViewHolder holder, int position) {
        holder.img.setImageResource(list.get(position).getImg());
        holder.name.setText(list.get(position).getName());
        int newIndex= position;
        if(check) {
            ArrayList<HomeProductModel> listProducts = new ArrayList<>();
            listProducts.add(new HomeProductModel(R.drawable.pizza1, "Pizza 1", "10h-20h", "4", "price: 10"));
            listProducts.add(new HomeProductModel(R.drawable.pizza2, "Pizza 2", "10h-20h", "3", "price: 20"));
            listProducts.add(new HomeProductModel(R.drawable.pizza3, "Pizza 3", "10h-20h", "2", "price: 30"));
            listProducts.add(new HomeProductModel(R.drawable.pizza4, "Pizza 4", "10h-20h", "2", "price: 40"));

            selectedCategory.callBack(position, listProducts);
            check = false;
        }

            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    row_index = newIndex;

                    notifyDataSetChanged();

                    if (row_index == 0) {
                        ArrayList<HomeProductModel> listProducts = new ArrayList<>();
                        listProducts.add(new HomeProductModel(R.drawable.pizza1, "Pizza 12", "10h-20h", "4", "10"));
                        listProducts.add(new HomeProductModel(R.drawable.pizza2, "Pizza 2", "10h-20h", "3", "20"));
                        listProducts.add(new HomeProductModel(R.drawable.pizza3, "Pizza 3", "10h-20h", "2", "30"));
                        listProducts.add(new HomeProductModel(R.drawable.pizza4, "Pizza 4", "10h-20h", "2", "40"));

                        selectedCategory.callBack(newIndex, listProducts);
                    } else if(row_index == 1) {
                        ArrayList<HomeProductModel> listProducts = new ArrayList<>();
                        listProducts.add(new HomeProductModel(R.drawable.burger1, "burger1", "10h-20h", "4", "10"));
                        listProducts.add(new HomeProductModel(R.drawable.burger2, "burger2", "10h-20h", "3", "20"));
                        listProducts.add(new HomeProductModel(R.drawable.burger4, "burger4", "10h-20h", "2", "30"));

                        selectedCategory.callBack(newIndex, listProducts);
                    } else if(row_index == 2) {
                        ArrayList<HomeProductModel> listProducts = new ArrayList<>();
                        listProducts.add(new HomeProductModel(R.drawable.fries1, "fries1 1", "10h-20h", "4", "10"));
                        listProducts.add(new HomeProductModel(R.drawable.fries2, "fries2 21", "10h-20h", "3", "20"));
                        listProducts.add(new HomeProductModel(R.drawable.fries3, "fries3 33", "10h-20h", "2", "30"));
                        listProducts.add(new HomeProductModel(R.drawable.fries4, "fries4 4", "10h-20h", "2", "40"));

                        selectedCategory.callBack(newIndex, listProducts);
                    }
                    else if(row_index == 3) {
                        ArrayList<HomeProductModel> listProducts = new ArrayList<>();
                        listProducts.add(new HomeProductModel(R.drawable.icecream2, "icecream2", "10h-20h", "4", "11"));
                        listProducts.add(new HomeProductModel(R.drawable.icecream1, "icecream1 ", "10h-20h", "3", "21"));
                        listProducts.add(new HomeProductModel(R.drawable.icecream3, "icecream3 ", "10h-20h", "2", "35"));
                        listProducts.add(new HomeProductModel(R.drawable.icecream4, "icecream4 ", "10h-20h", "2", "6"));

                        selectedCategory.callBack(newIndex, listProducts);
                    }
                    else if(row_index == 4) {
                        ArrayList<HomeProductModel> listProducts = new ArrayList<>();
                        listProducts.add(new HomeProductModel(R.drawable.sandwich1, "sandwich1", "10h-20h", "4", "8"));
                        listProducts.add(new HomeProductModel(R.drawable.sandwich2, "sandwich2 ", "10h-20h", "3", "6"));
                        listProducts.add(new HomeProductModel(R.drawable.sandwich3, "sandwich3 ", "10h-20h", "2", "3"));
                        listProducts.add(new HomeProductModel(R.drawable.sandwich4, "sandwich4 ", "10h-20h", "2", "12"));

                        selectedCategory.callBack(newIndex, listProducts);
                    }
                }
            });

            if(selected) {
                if(position == 0) {
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                    selected = false;
                }
            }else {
                if(row_index == position) {
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                }else {
                    holder.cardView.setBackgroundResource(R.drawable.dynamic_rv_bg);
                }
            }
        }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;

        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            img = itemView.findViewById(R.id.item_img);
            name = itemView.findViewById(R.id.item_text);
        }
    }
}
