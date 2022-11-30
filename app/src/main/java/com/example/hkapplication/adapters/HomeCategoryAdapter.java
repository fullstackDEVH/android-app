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
            listProducts.add(new HomeProductModel(R.drawable.pizza_seafood, "Pizza Seafood", "10h-20h", "4", "10"));
            listProducts.add(new HomeProductModel(R.drawable.pizza2, "Pizza Sausage 1", "10h-19h", "3", "20"));
            listProducts.add(new HomeProductModel(R.drawable.pizza3, "Pizza vegetarian", "10h-20h", "2", "30"));
            listProducts.add(new HomeProductModel(R.drawable.pizza4, "Pizza Pepperonis", "10h-20h", "2", "40"));
            listProducts.add(new HomeProductModel(R.drawable.pizza_sausage, "Pizza Sausage 2", "10h-20h", "2", "40"));
            listProducts.add(new HomeProductModel(R.drawable.pizza4, "Pizza Margherita", "10h-20h", "2", "40"));
            listProducts.add(new HomeProductModel(R.drawable.pizza_hawaii, "Pizza Hawaii", "10h-18h", "2", "40"));

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
                        listProducts.add(new HomeProductModel(R.drawable.pizza_seafood, "Pizza Seafood", "10h-20h", "4", "10"));
                        listProducts.add(new HomeProductModel(R.drawable.pizza2, "Pizza Sausage 1", "10h-19h", "3", "20"));
                        listProducts.add(new HomeProductModel(R.drawable.pizza3, "Pizza vegetarian", "10h-20h", "4", "30"));
                        listProducts.add(new HomeProductModel(R.drawable.pizza4, "Pizza Pepperonis", "10h-20h", "5", "20"));
                        listProducts.add(new HomeProductModel(R.drawable.pizza_sausage, "Pizza Sausage 2", "10h-20h", "5", "40"));
                        listProducts.add(new HomeProductModel(R.drawable.pizza4, "Pizza Margherita", "10h-20h", "2", "40"));
                        listProducts.add(new HomeProductModel(R.drawable.pizza_hawaii, "Pizza Hawaii", "10h-18h", "2", "40"));

                        selectedCategory.callBack(newIndex, listProducts);
                    } else if(row_index == 1) {
                        ArrayList<HomeProductModel> listProducts = new ArrayList<>();
                        listProducts.add(new HomeProductModel(R.drawable.burger1, "burger cow 1", "10h-20h", "4", "18"));
                        listProducts.add(new HomeProductModel(R.drawable.burger2, "burger cheese", "10h-20h", "3", "20"));
                        listProducts.add(new HomeProductModel(R.drawable.burger4, "burger cow 2", "10h-20h", "4", "15"));
                        listProducts.add(new HomeProductModel(R.drawable.burger_fish, "burger fish", "10h-20h", "5", "30"));
                        listProducts.add(new HomeProductModel(R.drawable.burger_chicken, "burger chicken", "10h-20h", "4", "30"));

                        selectedCategory.callBack(newIndex, listProducts);
                    } else if(row_index == 2) {
                        ArrayList<HomeProductModel> listProducts = new ArrayList<>();
                        listProducts.add(new HomeProductModel(R.drawable.fries_avocado, "Avocado fries", "10h-20h", "5", "30"));
                        listProducts.add(new HomeProductModel(R.drawable.fries1, "fries type 1", "10h-20h", "4", "14"));
                        listProducts.add(new HomeProductModel(R.drawable.fries2, "fries type 2", "10h-20h", "3", "20"));
                        listProducts.add(new HomeProductModel(R.drawable.fries3, "fries type 3", "10h-20h", "2", "30"));
                        listProducts.add(new HomeProductModel(R.drawable.fries4, "fries type 4", "10h-20h", "4", "33"));

                        selectedCategory.callBack(newIndex, listProducts);
                    }
                    else if(row_index == 3) {
                        ArrayList<HomeProductModel> listProducts = new ArrayList<>();
                        listProducts.add(new HomeProductModel(R.drawable.icecream2, "ice cream type 1", "10h-20h", "4", "11"));
                        listProducts.add(new HomeProductModel(R.drawable.icecream1, "ice cream type 2 ", "10h-20h", "3", "18"));
                        listProducts.add(new HomeProductModel(R.drawable.icecream3, "ice cream type 3 ", "10h-20h", "2", "20"));
                        listProducts.add(new HomeProductModel(R.drawable.icecream4, "ice cream type 4 ", "10h-20h", "2", "10"));

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

    public void a () {

    }
}
