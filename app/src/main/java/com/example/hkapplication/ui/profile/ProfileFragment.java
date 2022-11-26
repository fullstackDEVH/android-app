package com.example.hkapplication.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.hkapplication.MainActivity;
import com.example.hkapplication.R;
import com.example.hkapplication.databinding.FragmentProfileBinding;
import com.example.hkapplication.models.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class ProfileFragment extends Fragment {
    FirebaseAuth auth;
    DatabaseReference database;

    TextView profileName, profileEmail, profilePhone, profileAddress;

    private FragmentProfileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        auth = FirebaseAuth.getInstance();

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        database = FirebaseDatabase.getInstance().getReference();

        database.child("User").child( auth.getCurrentUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(getContext(), "Err: "+task.getException(), Toast.LENGTH_SHORT).show();
                }
                else {
                    UserModel user = task.getResult().getValue(UserModel.class);

                    profileName = root.findViewById(R.id.profile_name);
                    profileAddress = root.findViewById(R.id.profile_address);
                    profileEmail = root.findViewById(R.id.profile_email);
                    profilePhone = root.findViewById(R.id.profile_phone);

                    profileName.setText(user.getFullName());
                    profileAddress.setText("quảng ngãi");
                    profileEmail.setText(user.getEmail());
                    profilePhone.setText("0385151122");
                }
            }
        });

        root.findViewById(R.id.profile_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.child("User").child(auth.getUid()).child("fullName").setValue(profileName.getText().toString());
                Toast.makeText(getContext(), "Updating successfully !!", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}