package com.example.hkapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hkapplication.R;
import com.example.hkapplication.models.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    EditText fullname, email, password;
    Button btn;
    FirebaseAuth auth;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullname = findViewById(R.id.text_fullname);
        email = findViewById(R.id.text_email);
        password = findViewById(R.id.text_password);
        btn = findViewById(R.id.button_regis);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });
    }

    private void createUser() {
        String userName = fullname.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();

        if(TextUtils.isEmpty(userName)) {
            Toast.makeText(this, "name is empty !!!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userEmail)) {
            Toast.makeText(this, "email is empty !!!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userPassword)) {
            Toast.makeText(this, "password is empty !!!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(userPassword.length() < 6 ) {
            Toast.makeText(this, "password length must be greater than 6 character!!", Toast.LENGTH_SHORT).show();
            return;
        }
        // Create user
       auth.createUserWithEmailAndPassword(userEmail, userPassword)
               .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful()) {
                           UserModel userModel = new UserModel(userName,userEmail,userPassword);
                           String id = task.getResult().getUser().getUid();

                           database.getReference().child("User").child(id).setValue(userModel);
//                           progress.setVisibility(View.GONE);

                           Toast.makeText(RegisterActivity.this, "Create Successfully !!!", Toast.LENGTH_SHORT).show();
                       }else {
//                           progress.setVisibility(View.GONE);
                           Toast.makeText(RegisterActivity.this, "Error: " + task.getException(), Toast.LENGTH_SHORT).show();
                       }
                   }
               });
    }


    public void switchBtn(View v) {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }
}