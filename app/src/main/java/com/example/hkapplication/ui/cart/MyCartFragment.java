package com.example.hkapplication.ui.cart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hkapplication.R;
import com.example.hkapplication.adapters.CartAdapter;
import com.example.hkapplication.models.CartModel;

import java.util.ArrayList;
import java.util.List;


public class MyCartFragment extends Fragment {
    List<CartModel> list;
    CartAdapter cartAdapter;
    RecyclerView recyclerView;

    public MyCartFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);

        recyclerView = view.findViewById(R.id.cart_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();
        list.add(new CartModel(R.drawable.s1, "Order 1", "100", "4.6"));
        list.add(new CartModel(R.drawable.s2, "Order 2", "200", "2.6"));
        list.add(new CartModel(R.drawable.fav1, "Order 3", "300", "5.6"));
        list.add(new CartModel(R.drawable.s4, "Order 4", "400", "3.6"));

        cartAdapter = new CartAdapter(list);
        recyclerView.setAdapter(cartAdapter);
        return view;
    }
}