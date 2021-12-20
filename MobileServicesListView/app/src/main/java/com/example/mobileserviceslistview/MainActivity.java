package com.example.mobileserviceslistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();

        listView = findViewById(R.id.listview);

        String[] serviceValues = new String []
                {
                        "Safaricom",
                        "Send Money",
                        "Withdraw Cash",
                        "Loans and Savings",
                        "lipa na MPESA",
                        "My Account"
                };

        String [] services;
        services = res.getStringArray(R.array.services);


        ArrayAdapter <String> adapter = new ArrayAdapter <>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, services);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 1)
                {
                    Intent intent = new Intent(getApplicationContext(), SendMoney.class);
                    Toast.makeText(getApplicationContext(),adapter.getItem(position),Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });



    }
}