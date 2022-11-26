package com.example.hkapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hkapplication.R;
import com.example.hkapplication.models.HomeProductModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeProductAdapter extends RecyclerView.Adapter<HomeProductAdapter.ViewHolder> {
    Context context;
    ArrayList<HomeProductModel> list;
    BottomSheetDialog bottomSheetDialog;
    FirebaseAuth auth;
    FirebaseFirestore db;

    DatabaseReference mDatabase;

    public HomeProductAdapter(Context context, ArrayList<HomeProductModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HomeProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeProductAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeProductAdapter.ViewHolder holder, int position) {
        String bName = list.get(position).getName();
        String bTime = list.get(position).getTime();
        String bRating = list.get(position).getRating();
        String bPrice = list.get(position).getPrice();
        int bImg = list.get(position).getImg();

        holder.img.setImageResource(list.get(position).getImg());
        holder.name.setText(list.get(position).getName());
        holder.rating.setText(list.get(position).getRating());
        holder.price.setText(list.get(position).getPrice());
        holder.time.setText(list.get(position).getTime());

        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetTheme);
                View bottomView =  LayoutInflater.from(context).inflate(R.layout.bottom_layout, null);

                bottomView.findViewById(R.id.bottom_layout_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Map<String, Object> cart = new HashMap<>();
                        cart.put("name", bName);
                        cart.put("price", bPrice);
                        cart.put("rating", bRating);
                        cart.put("img", bImg);

                        db.collection("carts").document(auth.getCurrentUser().getUid())
                                .collection("currentUser")
                                .add(cart).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                    @Override
                                    public void onComplete(@NonNull Task<DocumentReference> task) {
                                        Toast.makeText(context, "add to cart "+bName, Toast.LENGTH_SHORT).show();
                                    }
                                });
                        bottomSheetDialog.dismiss();
                    }
                });

                ImageView bottom_layout_img = bottomView.findViewById(R.id.bottom_layout_img);
                TextView bottom_layout_name = bottomView.findViewById(R.id.bottom_layout_name);
                TextView bottom_layout_price = bottomView.findViewById(R.id.bottom_layout_price);
                TextView bottom_layout_rating = bottomView.findViewById(R.id.bottom_layout_rating);
                TextView bottom_layout_time = bottomView.findViewById(R.id.bottom_layout_time);
                TextView bottom_layout_desc = bottomView.findViewById(R.id.bottom_layout_description);


                bottom_layout_name.setText(bName);
                bottom_layout_price.setText(bPrice);
                bottom_layout_time.setText(bTime);
                bottom_layout_rating.setText(bRating);
                bottom_layout_desc.setText("size: m-l-xl");
                bottom_layout_img.setImageResource(bImg);

                bottomSheetDialog.setContentView(bottomView);
                bottomSheetDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name, time, rating, price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.card_img);
            name = itemView.findViewById(R.id.text_product_name);
            time = itemView.findViewById(R.id.text_time);
            rating = itemView.findViewById(R.id.text_rating);
            price = itemView.findViewById(R.id.text_price);
        }
    }



}
