package com.example.firebaseapplication;

        import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    EditText mail,phone,LastName,FirstName;
    Button save,next;
    DatabaseReference reff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail=findViewById(R.id.mail);
        phone=findViewById(R.id.Phone);
        LastName=findViewById(R.id.LastName);
        FirstName=findViewById(R.id.FirstName);
        save=findViewById(R.id.save);
        next=findViewById(R.id.next);


        reff= FirebaseDatabase.getInstance().getReference().child("Member");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //member.setFirstName(FirstName.getText().toString().trim());
                // member.setLastName(LastName.getText().toString().trim());
                // member.setMail(mail.getText().toString().trim());
                //  member.setPhone(phone.getText().toString().trim());
                //String key=reff.push().getKey();
                Member member=new Member(FirstName.getText().toString().trim(),LastName.getText().toString().trim(),mail.getText().toString().trim(),phone.getText().toString().trim());
                //reff.child(key).setValue(member);

                reff.child("member1").setValue(member);

                //reff.push().setValue(member);

                Toast.makeText(getApplicationContext(),"Data inserted Succesfully",Toast.LENGTH_SHORT).show();

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Home.class);
                startActivity(i);

            }
        });


    }
}