package com.example.hkapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hkapplication.MainActivity;
import com.example.hkapplication.R;

import com.example.hkapplication.adapters.HomeCategoryAdapter;
import com.example.hkapplication.adapters.HomeProductAdapter;
import com.example.hkapplication.adapters.SelectedCategory;
import com.example.hkapplication.databinding.FragmentHomeBinding;
import com.example.hkapplication.models.HomeCategoryModel;
import com.example.hkapplication.models.HomeProductModel;
import com.example.hkapplication.models.UserModel;
import com.example.hkapplication.ui.profile.ProfileFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HomeFragment extends Fragment implements SelectedCategory {

    private FragmentHomeBinding binding;

    Button btnProfileHome;
    DatabaseReference database;
    FirebaseAuth auth;
    TextView text_name, text_email, textViewUser;

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

        database = FirebaseDatabase.getInstance().getReference();
        auth = FirebaseAuth.getInstance();

        text_name = (TextView)root.findViewById(R.id.user_name);
        text_email = (TextView)root.findViewById(R.id.user_email);
        textViewUser = (TextView)root.findViewById(R.id.textView_user);

        root.findViewById(R.id.img_home_profile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*database.child("Users").child(auth.getUid()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(getContext(), "Err: "+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                        else {
                            UserModel user = task.getResult().getValue(UserModel.class);

                            textViewUser.setText("hello " + user.getFullName().toLowerCase(Locale.ROOT));
                            text_name.setText(""+user.getFullName());
                            text_email.setText(""+user.getEmail());
                        }
                    }
                });*/
            }
        });

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