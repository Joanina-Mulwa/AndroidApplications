package com.example.updatedassignment1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.updatedassignment1.ui.main.SectionsPagerAdapter;
import com.example.updatedassignment1.databinding.ActivityTabbedBinding;

public class TabbedActivity extends AppCompatActivity {

    private ActivityTabbedBinding binding;
    DataBaseHelper db;
    public int registerIdNumber, totalCartPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = new DataBaseHelper(getApplicationContext());

        binding = ActivityTabbedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = binding.fab;



        /*buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "You Made it Boi!", Toast.LENGTH_LONG).show();
            }
        });*/

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Cart Contents total Price : " + String.valueOf(totalCartPrice), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void submitRegisterDetails(View v){
        //Declare the widgets when the button is clicked.
        EditText registerFullNameET = findViewById(R.id.fragmentRegisterFullNameEditText);
        EditText registerAddressET = findViewById(R.id.register_address);
        EditText registerIdNumberET = findViewById(R.id.register_id_number);
        TextView genderTextView = findViewById(R.id.gender_text_view);
        Spinner genderSpinner = findViewById(R.id.register_gender_spinner);


        String registerGender = genderSpinner.getSelectedItem().toString();
        String registerFullName = registerFullNameET.getText().toString();
        String registerAddress = registerAddressET.getText().toString();
        registerIdNumber = Integer.parseInt(String.valueOf(registerIdNumberET.getText()));

        boolean isInsertRegisterData = db.insertRegisterData(registerIdNumber, registerFullName, registerAddress, registerGender);
        if(isInsertRegisterData){
            Toast.makeText(getApplicationContext(), "SUCCESS! Details Inserted To Database!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "ERROR! Details NOT Inserted!", Toast.LENGTH_LONG).show();
        }
        genderTextView.setText(registerGender);
    }

    public void checkOutPurchase(View v){
        TextView checkoutTextView = findViewById(R.id.checkout_text_view);
        db.printDatabaseContents("REGISTER_CREDENTIALS");

        System.out.println("Registered ID Number is = " + registerIdNumber);
        boolean isRetrieveDataSuccess = db.retrieveRegisterDataForUserWithId(registerIdNumber);
        if(isRetrieveDataSuccess){
            Toast.makeText(getApplicationContext(), "Checkout Data Retrieved Successfully!", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Error in retrieval!", Toast.LENGTH_SHORT).show();
        }
    }

    int samsungTvsAdded = 0;
    public void samsungAddedToCart(View v){
        ++samsungTvsAdded;
        int samsungPrice = 90000;
        totalCartPrice += samsungPrice;
        Button samsungAddCartButton = findViewById(R.id.samsung_add_to_cart);
        samsungAddCartButton.setText("Added (" + String.valueOf(samsungTvsAdded) + ")");
    }

    int lgTvsAdded = 0;
    public void lgAddedToCart(View v){
        ++lgTvsAdded;
        int lgPrice = 110000;
        totalCartPrice += lgPrice;
        Button samsungAddCartButton = findViewById(R.id.lg_add_to_cart);
        samsungAddCartButton.setText("Added (" + String.valueOf(lgTvsAdded) + ")");
    }

    int hisenseTvsAdded = 0;
    public void hisenseAddedToCart(View v){
        ++hisenseTvsAdded;
        int hisensePrice = 150000;
        totalCartPrice += hisensePrice;
        Button samsungAddCartButton = findViewById(R.id.hisense_add_to_cart);
        samsungAddCartButton.setText("Added (" + String.valueOf(hisenseTvsAdded) + ")");
    }

}