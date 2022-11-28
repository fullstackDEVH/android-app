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

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ProfileFragment extends Fragment {
    FirebaseAuth auth;
    DatabaseReference database;

    TextView profileName, profileEmail, profilePhone, profileAddress;

    private FragmentProfileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance().getReference();
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


            database.child("Users").child( auth.getCurrentUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(getContext(), "Err: "+task.getException(), Toast.LENGTH_SHORT).show();
                }
                else {
                    UserModel user = task.getResult().getValue(UserModel.class);

                    profileName = getView().findViewById(R.id.profile_name);
                    profileAddress = getView().findViewById(R.id.profile_address);
                    profileEmail = getView().findViewById(R.id.profile_email);
                    profilePhone = getView().findViewById(R.id.profile_phone);

                    profileName.setText(user.getFullName());
                    profileAddress.setText(user.getAddress());
                    profileEmail.setText(user.getEmail());
                    profilePhone.setText(user.getPhone());
                }
            }
        });

        root.findViewById(R.id.profile_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                profileName = getView().findViewById(R.id.profile_name);
                profileAddress = getView().findViewById(R.id.profile_address);
//                profileEmail = getView().findViewById(R.id.profile_email);
                profilePhone = getView().findViewById(R.id.profile_phone);

                  FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                String studentUser = firebaseAuth.getCurrentUser().getUid();

                final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(studentUser);
                String replaceName = profileName.getText().toString().trim();
                String replacePhoneNumber = profilePhone.getText().toString().trim();
                String replaceAddress = profileAddress.getText().toString().trim();

                Map<String, Object> updates = new HashMap<>();
                updates.put("fullName", replaceName);
                updates.put("phone", replacePhoneNumber);
                updates.put("address", replaceAddress);

                databaseReference.updateChildren(updates);

                Toast.makeText(getContext(), "Changes has been made", Toast.LENGTH_SHORT).show();
//                database.child("Users").child(auth.getUid()).child("fullName").setValue(profileName.getText().toString());

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