package com.example.listviewdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);

        String values[] = new String[]{
                "Facebook",
                "Whatsapp",
                "Youtube",
                "Tiktok",
                "Vid-mate"

        };

        ArrayAdapter <String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, android.R.id.text1,values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(),adapter.getItem(i),Toast.LENGTH_SHORT).show();


                if(i==0)
                {

                    Intent intent = new Intent(getApplicationContext(),Facebook.class);
                    startActivity(intent);
                }
                else if (i==1)
                {

                    Intent intent = new Intent(getApplicationContext(),Whatsapp.class);
                    startActivity(intent);
                }
                else if(i==2)
                {

                    Intent intent = new Intent(getApplicationContext(),Youtube.class);
                    startActivity(intent);
                }
                else if(i==3)
                {

                    Intent intent = new Intent(getApplicationContext(),Tiktok.class);
                    startActivity(intent);
                }
                else if (i==4)
                {

                    Intent intent = new Intent(getApplicationContext(),Vidmate.class);
                    startActivity(intent);
                }
                else
                {
                    System.out.println("Error");
                }

            }
        });

    }

}