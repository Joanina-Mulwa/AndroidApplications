package com.example.pleasework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //App compat Activity manages your activity environment
    //Main Activity inherits this class

    private EditText name,regNo,gender,email,id,phoneNumber;
    Button button;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Executes when activity is loaded

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //binding
        name = findViewById(R.id.name);
        regNo = findViewById(R.id.regNo);
        gender = findViewById(R.id.gender);
        email = findViewById(R.id.email);
        id = findViewById(R.id.id);
        phoneNumber = findViewById(R.id.phoneNumber);

        button = findViewById(R.id.nextBTN);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SINGLE PASS
//                Intent i = new Intent(getApplicationContext(),MainActivity2.class);
//                text = name.getText().toString();
//                i.putExtra("keyName", text);
//                startActivity(i);

                //BUNDLE PASS
                Intent i = new Intent(getApplicationContext(),MainActivity2.class);
                text = name.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("keyName",text);
                i.putExtras(bundle);
                startActivity(i);
            }
        });



        Details obj = new Details("Joey", "C026","Female", "jeey@gmail", 1234567890, 3001);
        obj.name="Joey";
        obj.regNo= "C026-01-1310/2019";
        obj.gender="Male";
        obj.email="Joey@gmail.com";
        obj.id=1234;
        obj.phoneNumber=12345;


        name.setText(obj.getName());
        regNo.setText(obj.showRegNo());
        gender.setText(obj.gender);
        email.setText(obj.email);
        id.setText(Integer.toString(obj.id));
        phoneNumber.setText(Integer.toString(obj.phoneNumber));


        //OCTOBER 7TH 2021 NOTES

        //put text to text view
        //textView.setText(obj.name)

        //get text from edit text
        //editText.getText()

        //INTENT
        //It is a means of starting a service
       //OBJECT :  Intent intent = new Intent()

        //Two categories: Implicit and explicit
        //Implicit intent are used to start other applications within the operating system platform
        //eg if you need an app that will use your camera

        //Explicit intent are used to start other activities

       // created on the on create method of the activity you are jumping from.

        //on creating objet, it requires two parameters
        //: class you are jumping from  ie getApplicationContext()

        //: class you are jumping to ie Details.class

        // Example:
        //Intent intent = new Intent(getApplicationContext(), Details.class);
                //parse the data for one activity to another
        //startActivity(intent);

        //To click a button and jump to next activity,
        //write the sample intent code in the button on click method

        //Ways of parsing the data:
            //single pass of data values;
            //collective pass of data values(using bundle)
            //Adapter class(here create many data instances)

        //***************************************************
            //Single pass Example
//                Intent intent = new Intent(getApplicationContext(), Details.class);
//                        //Put Extra has two parameters:
//                        //key which is a String
//                        //Data value or item
//                intent.putExtra("keyName", "Joan");
//                intent.putExtra("keyAge", "25");
//                intent.putExtra("keyId", "12345");
//                startActivity(intent);


        //*******************************************************************
        //now the activity you are sending the data to  must receive the data
        //receive method b the get intent method
        //this method is on the on create method of the second activity


        //Example:
//        Intent intent1 = getIntent();
//        intent1.getStringExtra("keyName");
//        intent1.getIntExtra("ketId", 0);
//        intent1.getIntExtra("keyPhoneNumber", 0);



        //to show the names on the text view CREATED EARLIER:
//                        name.setText(intent1.getStringExtra("keyName"));
//                        id.setText(Integer.toString(intent1.getIntExtra("keyId", 0)));
//                        phoneNumber.setText(Integer.toString(intent1.getIntExtra("keyPhoneNumber", 0)));




        //***************************************************************************



        //Using bundle
//                Intent intent3 = new Intent(getApplicationContext(), Details.class);
//                Bundle bundle = new Bundle();
//                bundle.putStringExtra("key1","Joan");
//                bundle.putIntExtra("key1",25);
//                bundle.putIntExtra("key1",234);
//
//                intent3.putExtras(bundle);
                // startActivity(intent3);



       // Receive Bundle
        //0 is the default value
//                Intent intent3 = getIntent();
//                Bundle et = new Bundle();
//                et.getStringExtras("keyName");
//                et.getStringExtras("keyId", 0);
//                et.getStringExtras("keyPhoneNumber", 0);

        //*****************************************





    }


    // OCT 7th Commented Notes
    // this is where you insert your own methods
    // has visibility specifier eg public, private, protected
    //    return type
    //    method name
    //    parameters
    // method body


}