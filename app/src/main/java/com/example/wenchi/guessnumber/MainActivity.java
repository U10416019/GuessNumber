package com.example.wenchi.guessnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button buttonSinglePlayer;
    private Button buttonTwoPlayer;
    private Button buttonMultiplePlayer;
    private Button rule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner = (Spinner)findViewById(R.id.spinner);
        //spinner.setVisibility(View.GONE);
        ArrayAdapter<CharSequence> peopleNumberSpinner = ArrayAdapter.createFromResource(MainActivity.this,
                R.array.peopleNumber,
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(peopleNumberSpinner);


        buttonSinglePlayer = (Button)findViewById(R.id.buttonSinglePlayer);
        buttonTwoPlayer = (Button)findViewById(R.id.buttonTwoPlayer);
        buttonMultiplePlayer = (Button)findViewById(R.id.buttonMultiplePlayer);
        rule = (Button)findViewById(R.id.rule);


        buttonTwoPlayer.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        //textShow.setText("時速 = " + Double.parseDouble(number.getText().toString()) * 1.60931 + "公里");
                        Intent choosePlayer = new Intent();
                        choosePlayer.setClass(MainActivity.this, ChoosePlayer.class);
                        startActivity(choosePlayer);
                    }
                });

    }
}
