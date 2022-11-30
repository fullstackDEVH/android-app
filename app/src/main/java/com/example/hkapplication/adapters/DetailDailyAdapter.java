package com.example.hkapplication.adapters;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hkapplication.R;
import com.example.hkapplication.models.DetailDailyModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailDailyAdapter extends RecyclerView.Adapter<DetailDailyAdapter.ViewHolder> {

    List<DetailDailyModel> list ;
    BottomSheetDialog bottomSheetDialog;
    FirebaseAuth auth;
    FirebaseFirestore db;

    DatabaseReference mDatabase;
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

        String bName = list.get(position).getName();
        String bTime = list.get(position).getTime();
        String bRating = list.get(position).getRating();
        String bPrice = list.get(position).getPrice();
        String bDesc = list.get(position).getDesc();
        int bImg = list.get(position).getImg();

        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        
        holder.itemView.findViewById(R.id.daily_detail_btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> cart = new HashMap<>();
                cart.put("name", bName);
                cart.put("price", bPrice);
                cart.put("rating", bRating);
                cart.put("img", bImg);

                db.collection("carts").document(auth.getUid())
                        .collection("currentUser")
                        .add(cart).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                if(task.isSuccessful()) {
                                    Toast.makeText(view.getContext(), "add to cart "+bName, Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(view.getContext(), "Error cart :" + task.getException(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog = new BottomSheetDialog(view.getContext(), R.style.BottomSheetTheme);
                View bottomView =  LayoutInflater.from(view.getContext()).inflate(R.layout.bottom_layout, null);

                bottomView.findViewById(R.id.bottom_layout_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        bottomSheetDialog.dismiss();
                    }
                });

                ImageView bottom_layout_img = bottomView.findViewById(R.id.bottom_layout_img);
                TextView bottom_layout_name = bottomView.findViewById(R.id.bottom_layout_name);
                TextView bottom_layout_price = bottomView.findViewById(R.id.bottom_layout_price);
                TextView bottom_layout_rating = bottomView.findViewById(R.id.bottom_layout_rating);
                TextView bottom_layout_time = bottomView.findViewById(R.id.bottom_layout_time);
                TextView bottom_layout_desc = bottomView.findViewById(R.id.bottom_layout_description);

                bottom_layout_name.setText(""+bName);
                bottom_layout_price.setText(""+bPrice);
                bottom_layout_time.setText(""+bTime);
                bottom_layout_rating.setText(""+bRating);
                bottom_layout_desc.setText(""+bDesc);
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
