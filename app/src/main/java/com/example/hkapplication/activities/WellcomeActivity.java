package com.example.hkapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hkapplication.R;

public class WellcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
    }

    public void register(View v) {
        startActivity(new Intent(WellcomeActivity.this, RegisterActivity.class));
    }

    public void signIn(View v) {
        startActivity(new Intent(WellcomeActivity.this, LoginActivity.class));
    }
}