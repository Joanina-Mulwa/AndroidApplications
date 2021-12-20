package com.example.mobileserviceslistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendMoney extends AppCompatActivity {

    EditText numberEdit, amountEdit;
    Button okayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);

        numberEdit = findViewById(R.id.number);
        amountEdit = findViewById(R.id.amount);
        okayButton = findViewById(R.id.okay);

        okayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = numberEdit.getText().toString();
                String amountLength = amountEdit.getText().toString();


                if(number.length() >= 10) {
                    if (amountLength.length() > 1) {
                        int amount = Integer.parseInt(amountEdit.getText().toString());
                        if (amount >= 50) {
                            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Minimum Amount is 50", Toast.LENGTH_SHORT).show();
                            amountEdit.setError("Minimum Amount is 50");
                            amountEdit.requestFocus();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Enter a Valid Amount", Toast.LENGTH_SHORT).show();
                        amountEdit.setError("Enter Amount");
                        amountEdit.requestFocus();
                    }

                }
                else
                    {
                        Toast.makeText(getApplicationContext(), "Enter a Valid Number", Toast.LENGTH_SHORT).show();
                        numberEdit.setError("Enter Number");
                        numberEdit.requestFocus();
                    }
                }
        });


    }
}