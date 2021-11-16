package com.example.updatedassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editUsername, editPassword;
    private Button buttonLogin, buttonSignup;
    DataBaseHelper db;
    //public String userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DataBaseHelper(getApplicationContext());

        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonSignup = findViewById(R.id.buttonSignup);

        /*userName = editUsername.getText().toString();
        password = editPassword.getText().toString();*/


        //insert data
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SignupActivity.class));
            }
        });
        //retrieve

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //db.deleteUserWithName("");
                db.printDatabaseContents("REGISTER_CREDENTIALS");//database has every detail. cursor value = 0;jgj

                boolean isUserExist = db.verifyThisUser(editUsername.getText().toString(), editPassword.getText().toString());


                if(isUserExist){
                    Toast.makeText(getApplicationContext(), "Login Success Welcome ", Toast.LENGTH_LONG).show();
                    //Start new activity:
                    startActivity(new Intent(getApplicationContext(), TabbedActivity.class));
                    finish();

                }
                else{
                    Toast.makeText(getApplicationContext(), "Login Failed! Check details or Sign UP!", Toast.LENGTH_LONG).show();
                    editUsername.setError("Check Username or Password!");
                    editPassword.setError("");
                    editUsername.requestFocus();
                }
            }
        });
    }
}