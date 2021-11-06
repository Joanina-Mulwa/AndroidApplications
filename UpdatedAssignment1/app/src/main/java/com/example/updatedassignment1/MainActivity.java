package com.example.updatedassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editUsername, editPassword;
    private Button buttonLogin, buttonSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonSignup = findViewById(R.id.buttonSignup);

        //this will call our constructor in class DataBaseHelper and create our db and table
        DataBaseHelper db = new DataBaseHelper(this);

        //insert data
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameText = editUsername.getText().toString();
                String passwordText = editPassword.getText().toString();

                Boolean checkInsertData = db.insertUserData(nameText, passwordText);
                if (checkInsertData == true) {
                    Toast.makeText(getApplicationContext(), "New Entry Inserted", Toast.LENGTH_SHORT).show();
                    //Integer intent = new Intent(getApplicationContext(),mainACTIVITY2);

                } else
                    Toast.makeText(getApplicationContext(), "Error Inserting New Entry", Toast.LENGTH_SHORT).show();
            }


        });


        //retrieve


    }
}