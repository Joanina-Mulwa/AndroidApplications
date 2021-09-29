package com.example.comprasionthreevalues;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //declare all widgets
    private EditText editTextNumber,editTextNumber2,editTextNumber3;
    private TextView textView2;
    private Button addBTN,subtractBTN,multiplyBTN,divideBTN,largerBTN,smallerBTN;

    int first,second,third,ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind the widgets with the class logic
        addBTN = findViewById(R.id.addBTN);
        subtractBTN = findViewById(R.id.subtractBTN);
        multiplyBTN = findViewById(R.id.multiplyBTN);
        divideBTN = findViewById(R.id.divideBTN);
        largerBTN = findViewById(R.id.largerBTN);
        smallerBTN = findViewById(R.id.smallerBTN);

        editTextNumber = findViewById(R.id.editTextNumber);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        editTextNumber3 = findViewById(R.id.editTextNumber3);
        textView2 = findViewById(R.id.textView2);

        //get values from the edit texts
        addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                first = Integer.parseInt(editTextNumber.getText().toString());
                second = Integer.parseInt(editTextNumber2.getText().toString());
                third = Integer.parseInt(editTextNumber3.getText().toString());

                ans = first+second+third;

                textView2.setText(Integer.toString(ans));

            }
        });
        subtractBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                first = Integer.parseInt(editTextNumber.getText().toString());
                second = Integer.parseInt(editTextNumber2.getText().toString());
                third = Integer.parseInt(editTextNumber3.getText().toString());

                ans = (first-second)-third;

                textView2.setText(Integer.toString(ans));

            }
        });
        multiplyBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                first = Integer.parseInt(editTextNumber.getText().toString());
                second = Integer.parseInt(editTextNumber2.getText().toString());
                third = Integer.parseInt(editTextNumber3.getText().toString());

                ans = (first*second)*third;

                textView2.setText(Integer.toString(ans));

            }
        });

        divideBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                first = Integer.parseInt(editTextNumber.getText().toString());
                second = Integer.parseInt(editTextNumber2.getText().toString());
                third = Integer.parseInt(editTextNumber3.getText().toString());

                ans = (first/second)/third;

                textView2.setText(Integer.toString(ans));

            }
        });

        largerBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                first = Integer.parseInt(editTextNumber.getText().toString());
                second = Integer.parseInt(editTextNumber2.getText().toString());
                third = Integer.parseInt(editTextNumber3.getText().toString());

                ans = Math.max(first,Math.max(second,third));

                textView2.setText(Integer.toString(ans));

            }
        });

        smallerBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                first = Integer.parseInt(editTextNumber.getText().toString());
                second = Integer.parseInt(editTextNumber2.getText().toString());
                third = Integer.parseInt(editTextNumber3.getText().toString());

                ans = Math.min(first,Math.min(second,third));

                textView2.setText(Integer.toString(ans));

            }
        });





    }
}