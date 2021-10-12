package com.example.mybasiccalculator;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mybasiccalculator.databinding.ActivityMainBinding;

import android.text.SpannableStringBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        display = findViewById(R.id.input);

        //removes onscreen keyboard
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.display).equals(display.getText().toString()))
                {
                    display.setText("");
                }
            }
        });

    }



    private void updateText(String strToAdd)
    {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0 , cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);

        }
        else{
            display.setText(String.format("%s%s%s",leftStr, strToAdd, rightStr ));
        }
        display.setSelection(cursorPos + 1);


    }



    public void zeroBTN(View view){

        updateText("0");

    }
    public void oneBTN(View view){

        updateText("1");

    }
    public void twoBTN(View view){

        updateText("2");

    }
    public void threeBTN(View view){

        updateText("3");

    }
    public void fourBTN(View view){

        updateText("4");

    }
    public void fiveBTN(View view){

        updateText("5");

    }
    public void sixBTN(View view){

        updateText("6");

    }
    public void sevenBTN(View view){

        updateText("7");

    }
    public void eightBTN(View view){

        updateText("8");

    }
    public void nineBTN(View view){

        updateText("9");

    }


    public void clearBTN(View view){

        display.setText("");


    }
    public void exponentBTN(View view){

        updateText("^");

    }
    public void parenthesisBTN(View view){

        int curPos = display.getSelectionStart();
        int openPar = 0;
        int closedPar = 0;
        int textLen = display.getText().length();

        for (int i = 0; i < curPos; i++ )
        {
            if(display.getText().toString().charAt(i) == '(')
            {
                openPar += 1;
            }
            if(display.getText().toString().charAt(i) == ')')
            {
                closedPar += 1;
            }
        }

        if (openPar == closedPar || display.getText().toString().charAt(textLen - 1) == '(')
        {
            updateText("(");
        }
        else if (closedPar < openPar && display.getText().toString().charAt(textLen - 1) != '(')
        {
            updateText(")");
        }
        display.setSelection(curPos + 1);

    }


    public void divideBTN(View view){

        updateText("/");

    }
    public void multiplyBTN(View view){

        updateText("*");

    }
    public void addBTN(View view){

        updateText("+");

    }
    public void subtractBTN(View view){

        updateText("-");

    }


    public void plusMinusBTN(View view){

        updateText("-");

    }
    public void pointBTN(View view){

        updateText(".");

    }
    public void equalsBTN(View view){

    }



    public void backspaceBTN(View view){

        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0)
        {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);

        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}