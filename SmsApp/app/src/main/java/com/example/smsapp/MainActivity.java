package com.example.smsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS=0;
    Button sendBtn;
    EditText textPhoneNumber, textMessage;
    String phoneNumber;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = (Button) findViewById(R.id.sendBTN);
        textPhoneNumber = (EditText) findViewById(R.id.phoneNumber);
        textMessage = (EditText) findViewById(R.id.message);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSMSMessage();
            }
        });


    }

    protected void sendSMSMessage(){}

       /* phoneNumber = textPhoneNumber.getText().toString();
        message = textMessage.getText().toString();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)) != PackageManager.PERMISSION_DENIED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)){


            }
            else {
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);

            }
        }
    };*/

    public void onRequestPermissionsResult(int requestCode, String permission[], int[] grantResult)

    {
        switch (requestCode)
        {
            case MY_PERMISSIONS_REQUEST_SEND_SMS:{
                if(grantResult.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED)
                {
                    
                }
            }
        }

    }
}