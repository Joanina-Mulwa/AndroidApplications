package com.example.listviewdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Whatsapp extends AppCompatActivity {
    Button chats,groups,status,calls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp);

        chats = findViewById(R.id.chats);
        groups = findViewById(R.id.groups);
        status = findViewById(R.id.status);
        calls = findViewById(R.id.calls);

        chats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Chats", Toast.LENGTH_SHORT).show();
            }
        });

    }
}