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

    private boolean isUserFilledAllRegister;
    private String registerGender,registerFullName,registerAddress;
    public void submitRegisterDetails(View v){
        //Declare the widgets when the button is clicked.
        EditText registerFullNameET = findViewById(R.id.fragmentRegisterFullNameEditText);
        EditText registerAddressET = findViewById(R.id.register_address);
        EditText registerIdNumberET = findViewById(R.id.register_id_number);
        TextView genderTextView = findViewById(R.id.gender_text_view);
        Spinner genderSpinner = findViewById(R.id.register_gender_spinner);

        //Check to ensure the user has input correct data.
        if(registerFullNameET.getText().toString().length() < 1){
            registerFullNameET.setError("Enter Full Name!");
            registerFullNameET.requestFocus();
            return;
        }

        if(registerAddressET.getText().toString().length() < 1){
            registerAddressET.setError("Enter Address!");
            registerAddressET.requestFocus();
            return;
        }

        if(registerIdNumberET.getText().toString().length() < 1){
            registerIdNumberET.setError("Enter ID Number!");
            registerIdNumberET.requestFocus();
            return;
        }

        isUserFilledAllRegister = true;

         registerGender = genderSpinner.getSelectedItem().toString();
         registerFullName = registerFullNameET.getText().toString();
         registerAddress = registerAddressET.getText().toString();
        registerIdNumber = Integer.parseInt(String.valueOf(registerIdNumberET.getText()));

        boolean isInsertRegisterData = db.insertRegisterData(registerIdNumber, registerFullName, registerAddress, registerGender);
        if(isInsertRegisterData){
            Toast.makeText(getApplicationContext(), "SUCCESS! REGISTERED!", Toast.LENGTH_LONG).show();
            registerAddressET.setText("");
            registerFullNameET.setText("");
            registerIdNumberET.setText("");
        }else{
            Toast.makeText(getApplicationContext(), "ERROR! ID Already Exists!", Toast.LENGTH_LONG).show();
        }
        //genderTextView.setText(registerGender);
    }

    public void checkOutPurchase(View v){

        if(!isUserFilledAllRegister){
            Toast.makeText(getApplicationContext(), "Fill all register details first.!", Toast.LENGTH_LONG).show();
            return;
        }

        TextView checkoutTextView = findViewById(R.id.checkout_text_view);
        db.printDatabaseContents("REGISTER_CREDENTIALS");

        System.out.println("Registered ID Number is = " + registerIdNumber);
        boolean isRetrieveDataSuccess = db.retrieveRegisterDataForUserWithId(registerIdNumber);
        if(isRetrieveDataSuccess){
            Toast.makeText(getApplicationContext(), "Checkout Data Retrieved Successfully!", Toast.LENGTH_LONG).show();
            String checkOutDetails = "Name : "+registerFullName+" \n\nShipping Address : "+registerAddress+" \n\nTotal Price : " +totalCartPrice+
                    "\n\n\nShop with us again!\nThank you!";

            checkoutTextView.setText(checkOutDetails);
        }
        else{
            Toast.makeText(getApplicationContext(), "Error in retrieval!", Toast.LENGTH_SHORT).show();
        }


    }

    int samsungTvsAdded = 0;
    public void samsungAddedToCart(View v){
        ++samsungTvsAdded;//value = 4
        if(checkIfItemsMoreThan3(samsungTvsAdded)){
            return;
        }
        int samsungPrice = 90000;
        totalCartPrice += samsungPrice;
        Button samsungAddCartButton = findViewById(R.id.samsung_add_to_cart);
        samsungAddCartButton.setText("Added (" +samsungTvsAdded + ")");

    }

    int lgTvsAdded = 0;
    public void lgAddedToCart(View v){
        ++lgTvsAdded;
        if(checkIfItemsMoreThan3(lgTvsAdded)){
            return;
        }
        int lgPrice = 110000;
        totalCartPrice += lgPrice;
        Button samsungAddCartButton = findViewById(R.id.lg_add_to_cart);
        samsungAddCartButton.setText("Added (" + String.valueOf(lgTvsAdded) + ")");
    }

    int hisenseTvsAdded = 0;
    public void hisenseAddedToCart(View v){
        ++hisenseTvsAdded;
        if(checkIfItemsMoreThan3(hisenseTvsAdded)){
            return;
        }
        int hisensePrice = 150000;
        totalCartPrice += hisensePrice;
        Button samsungAddCartButton = findViewById(R.id.hisense_add_to_cart);
        samsungAddCartButton.setText("Added (" + String.valueOf(hisenseTvsAdded) + ")");
    }

    private boolean checkIfItemsMoreThan3(int numberOfItems){
        if(numberOfItems > 3){
            Toast.makeText(getApplicationContext(), "Max items is 3", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

}