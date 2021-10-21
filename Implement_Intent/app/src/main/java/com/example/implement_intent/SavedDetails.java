package com.example.implement_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SavedDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_details);

        Intent intent1 = getIntent();
        intent1.getStringExtra("keyFirstName");
        intent1.getStringExtra("keyLastName");



    }
}