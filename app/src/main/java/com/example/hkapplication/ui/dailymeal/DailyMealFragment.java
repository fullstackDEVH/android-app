package com.example.hkapplication.ui.dailymeal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.hkapplication.adapters.DailyMealAdapter;
import com.example.hkapplication.databinding.FragmentDailyMealBinding;
import com.example.hkapplication.models.DailyModel;

import java.util.ArrayList;
import java.util.List;import com.example.hkapplication.R;

public class DailyMealFragment extends Fragment {

    private FragmentDailyMealBinding binding;
    DailyMealAdapter dailyMealAdapter;
    RecyclerView recyclerView;
    List<DailyModel> list;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDailyMealBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        recyclerView = root.findViewById(R.id.daily_meal_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();

        list.add(new DailyModel(R.drawable.breakfast, "Breakfast", "5% OFF", "breakfast","breakfast"));
        list.add(new DailyModel(R.drawable.lunch, "Lunch", "25% OFF","lunch", "lunch"));
        list.add(new DailyModel(R.drawable.dinner, "Dinner", "30% OFF", "dinner","dinner"));
        list.add(new DailyModel(R.drawable.sweets, "Sweet", "150% OFF", "sweets","sweets"));
        list.add(new DailyModel(R.drawable.coffe, "Coffee", "10% OFF", "coffee","coffee"));

        dailyMealAdapter = new DailyMealAdapter(getContext(), list);
        recyclerView.setAdapter(dailyMealAdapter);
        dailyMealAdapter.notifyDataSetChanged();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}