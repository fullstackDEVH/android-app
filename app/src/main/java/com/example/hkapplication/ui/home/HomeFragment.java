package com.example.hkapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.hkapplication.R;

import com.example.hkapplication.adapters.HomeCategoryAdapter;
import com.example.hkapplication.adapters.HomeProductAdapter;
import com.example.hkapplication.adapters.SelectedCategory;
import com.example.hkapplication.databinding.FragmentHomeBinding;
import com.example.hkapplication.models.HomeCategoryModel;
import com.example.hkapplication.models.HomeProductModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements SelectedCategory {

    private FragmentHomeBinding binding;

    RecyclerView recycleCategory, recyclerViewProduct;

//    category
    ArrayList<HomeCategoryModel> listCategory;
    HomeCategoryAdapter homeCategoryAdapter;

//    product
    ArrayList<HomeProductModel> listProduct ;
    HomeProductAdapter homeProductAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recycleCategory = root.findViewById(R.id.home_recycle);
        recyclerViewProduct = root.findViewById(R.id.home_products);

        //        categories
        listCategory = new ArrayList<HomeCategoryModel>();

        listCategory.add(new HomeCategoryModel(R.drawable.pizza, "pizza"));
        listCategory.add(new HomeCategoryModel(R.drawable.hamburger, "hamburger"));
        listCategory.add(new HomeCategoryModel(R.drawable.fried_potatoes, "potatoes"));
        listCategory.add(new HomeCategoryModel(R.drawable.ice_cream, "ice cream"));
        listCategory.add(new HomeCategoryModel(R.drawable.sandwich, "sandwich"));

        homeCategoryAdapter = new HomeCategoryAdapter(this, getActivity() ,listCategory);

        recycleCategory.setAdapter(homeCategoryAdapter);
        recycleCategory.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        recycleCategory.setHasFixedSize(true);
        recycleCategory.setNestedScrollingEnabled(false);

//       products
        listProduct = new ArrayList<>();

        homeProductAdapter = new HomeProductAdapter(getActivity(), listProduct);

        recyclerViewProduct.setAdapter(homeProductAdapter);
        recyclerViewProduct.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void callBack(int index, ArrayList<HomeProductModel> list) {
        homeProductAdapter = new HomeProductAdapter(getContext(), list);
        homeProductAdapter.notifyDataSetChanged();

        recyclerViewProduct.setAdapter(homeProductAdapter);
    }
}