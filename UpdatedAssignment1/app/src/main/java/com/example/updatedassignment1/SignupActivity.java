package com.example.updatedassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    EditText editUsername, editPassword;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editUsername = findViewById(R.id.editUsernameSignUp);
        editPassword = findViewById(R.id.editPasswordSignup);

        //this will call our constructor in class DataBaseHelper and create our db and table
        db = new DataBaseHelper(getApplicationContext());
    }

    public void SubmitDetails(View v){

        String nameText = editUsername.getText().toString();
        String passwordText = editPassword.getText().toString();

        if(nameText.length() < 1){
            editUsername.setError("Enter valid Username ");
            editUsername.requestFocus();
            return;
        }
        if(passwordText.length() < 1){
            editPassword.setError("Enter Password!");
            editPassword.requestFocus();
            return;
        }

        boolean checkInsertData = db.insertUserData(nameText, passwordText);
        //db.printDatabaseContents();
        //db.verifyThisUser("Eric Mwenda", "ericmwenda" );


        if (checkInsertData) {
            Toast.makeText(getApplicationContext(), "New Entry Inserted", Toast.LENGTH_SHORT).show();
            //Integer intent = new Intent(getApplicationContext(),mainACTIVITY2);
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        } else {
            Toast.makeText(getApplicationContext(), nameText + " Already Exists.", Toast.LENGTH_SHORT).show();
            editUsername.setError(nameText + " Already Exists!");
            editUsername.requestFocus();
        }
    }
}