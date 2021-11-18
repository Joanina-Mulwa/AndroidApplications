package com.example.updatedassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editUsername, editPassword;
    private Button buttonLogin, buttonSignup;
    private ImageButton buttonShowPassword;
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
        //buttonShowPassword=findViewById(R.id.showPasswordBtn);

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
                    editUsername.setError("Check Username!");
                    editPassword.setError("Check Password!");
                    editUsername.requestFocus();
                    editUsername.requestFocus();
                }
            }
        });
    }

/*    public  void showHidePassword(View v){

        if(v.getId()==R.id.showPasswordBtn){

            if(editPassword.getTransformationMethod().equals(PasswordTransformationMethod.getInstance()))
            {
                ((ImageButton)(v)).setImageResource(R.drawable.show_password);

                //Show Password
                editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            else{
                ((ImageButton)(v)).setImageResource(R.drawable.show_password);

                //Hide Password
                editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

            }
        }

    }*/
}