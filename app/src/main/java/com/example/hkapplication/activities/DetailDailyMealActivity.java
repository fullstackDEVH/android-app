package com.example.hkapplication.activities;

import com.example.hkapplication.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hkapplication.adapters.DailyMealAdapter;
import com.example.hkapplication.adapters.DetailDailyAdapter;
import com.example.hkapplication.models.DetailDailyModel;

import java.util.ArrayList;
import java.util.List;

public class DetailDailyMealActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DetailDailyModel> list;
    DetailDailyAdapter dailyAdapter;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_daily_meal);

//        get value from detail_dailymeal adapter (intent)
        String type = getIntent().getStringExtra("type");

        img = findViewById(R.id.daily_detail_img);


        recyclerView = findViewById(R.id.detailed_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        dailyAdapter = new DetailDailyAdapter(list);
        recyclerView.setAdapter(dailyAdapter);

        if(type != null && type.equalsIgnoreCase("breakfast")) {
            img.setImageResource(R.drawable.breakfast);
            list.add(new DetailDailyModel(R.drawable.breakfast_chicken_sticky_rice, "chicken sticky rice", "very delicious food", "4", "10", "10h-20h"));
            list.add(new DetailDailyModel(R.drawable.breakfast_beef_noodle_soup, "beef noodle soup", "very delicious food", "4", "10", "10h-20h"));
            list.add(new DetailDailyModel(R.drawable.fav1, "breakfast type 1", "very delicious food", "4", "10", "10h-20h"));
            list.add(new DetailDailyModel(R.drawable.breakfast_bread, "bread", "very delicious food", "4", "10", "10h-20h"));
            list.add(new DetailDailyModel(R.drawable.fav2, "breakfast type 2", "very delicious food", "4", "20", "10h-20h"));
            list.add(new DetailDailyModel(R.drawable.fav3, "breakfast type 3", "very delicious food", "6", "15", "10h-20h"));
            dailyAdapter.notifyDataSetChanged();
        }
        else if(type != null && type.equalsIgnoreCase("sweets")) {
            img.setImageResource(R.drawable.sweets);
            list.add(new DetailDailyModel(R.drawable.sweets_cake_strawberry, "cake strawberry", "very delicious food", "4", "10", "10h-20h"));
            list.add(new DetailDailyModel(R.drawable.sweets_cream_cake, "cream cake", "very delicious food", "4", "10", "10h-20h"));
            list.add(new DetailDailyModel(R.drawable.sweets_nut_cake, "nut cake", "very delicious food", "4", "10", "10h-20h"));
            list.add(new DetailDailyModel(R.drawable.s3, "cake type 1", "very delicious food", "3", "12", "10h-20h"));
            list.add(new DetailDailyModel(R.drawable.s1, "cake type 2", "very delicious food", "4", "10", "10h-20h"));
            list.add(new DetailDailyModel(R.drawable.s2, "cake type 3", "very delicious food", "3", "14", "10h-20h"));
            dailyAdapter.notifyDataSetChanged();
        }
        else if(type != null && type.equalsIgnoreCase("lunch")) {
            img.setImageResource(R.drawable.lunch);
            list.add(new DetailDailyModel(R.drawable.lunch_chicken_rice, "chicken rice", "very delicious food", "4", "10", "10h-20h"));
            list.add(new DetailDailyModel(R.drawable.lunch_pancakes, "pancakes", "very delicious food", "3", "16", ""));
            list.add(new DetailDailyModel(R.drawable.lunch_rib_rice, "rib rice", "very delicious food", "5", "18", ""));
            dailyAdapter.notifyDataSetChanged();
        }
        else if(type != null && type.equalsIgnoreCase("dinner")) {
            img.setImageResource(R.drawable.dinner);

            list.add(new DetailDailyModel(R.drawable.dinner_fried_beans, "fried beans", "very delicious food", "4", "10", "10h-20h"));
            list.add(new DetailDailyModel(R.drawable.dinner_fried_shrimp, "fried shrimp", "very delicious food", "3", "20", "10h-20h"));
            list.add(new DetailDailyModel(R.drawable.dinner_meatball, "meatball", "very delicious food", "4", "15", "10h-20h"));
            dailyAdapter.notifyDataSetChanged();
        }
        else if(type != null && type.equalsIgnoreCase("coffee")) {
            img.setImageResource(R.drawable.coffe);
            list.add(new DetailDailyModel(R.drawable.coffe_macchiato, "coffee macchiato", "very delicious food", "3", "10", "10h-20h"));
            list.add(new DetailDailyModel(R.drawable.coffe_espresso_con_panna, "coffee espresso con panna", "very delicious food", "3", "10", "10h-20h"));
            list.add(new DetailDailyModel(R.drawable.coffe_cappuchiano_viennese, "coffee cappuchiano viennese", "very delicious food", "4", "10", "10h-20h"));
            list.add(new DetailDailyModel(R.drawable.coffe_capuchino, "coffee capuchino", "very delicious food", "4", "30", "10h-20h"));
            list.add(new DetailDailyModel(R.drawable.coffe_latte, "coffee latte", "very delicious food", "3", "10", "10h-20h"));
            dailyAdapter.notifyDataSetChanged();
        }
    }
}