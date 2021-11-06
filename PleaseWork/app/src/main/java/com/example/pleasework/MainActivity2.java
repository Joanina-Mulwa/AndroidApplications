package com.example.pleasework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = findViewById(R.id.backBTN);
        textView = findViewById(R.id.text);
            //SINGLE RECEIVE
//        Intent i = getIntent();
//        i.getStringExtra("keyName");
//        textView.setText(i.getStringExtra("keyName"));

            //BUNDLE RECEIVE
            Intent intent3 = getIntent();
            Bundle et = new Bundle();
            et.getString("keyName");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });



    }
}