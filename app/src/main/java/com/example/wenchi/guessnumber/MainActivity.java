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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button buttonSinglePlayer;
    private Button buttonTwoPlayer;
    private Button buttonMultiplePlayer;
    private Button rule;
    private TextView textView;
    private Intent choosePlayer = new Intent();
    private Bundle bundle = new Bundle();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);

        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setVisibility(View.GONE);
        ArrayAdapter<CharSequence> peopleNumberSpinner = ArrayAdapter.createFromResource(MainActivity.this,
                R.array.peopleNumber,
                android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(peopleNumberSpinner);

        buttonSinglePlayer = (Button)findViewById(R.id.buttonSinglePlayer);
        buttonTwoPlayer = (Button)findViewById(R.id.buttonTwoPlayer);
        buttonMultiplePlayer = (Button)findViewById(R.id.buttonMultiplePlayer);
        rule = (Button)findViewById(R.id.rule);

        choosePlayer.setClass(MainActivity.this, ChoosePlayer.class);

        buttonSinglePlayer.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        //Intent choosePlayer = new Intent();
                        //choosePlayer.setClass(MainActivity.this, ChoosePlayer.class);
                        //Bundle bundle = new Bundle();
                        bundle.putInt("playerNumber", 1);
                        choosePlayer.putExtras(bundle);
                        startActivity(choosePlayer);
                    }
                });

        buttonTwoPlayer.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                       //Intent choosePlayer = new Intent();
                        //choosePlayer.setClass(MainActivity.this, ChoosePlayer.class);
                        //Bundle bundle = new Bundle();
                        bundle.putInt("playerNumber", 2);
                        choosePlayer.putExtras(bundle);
                        startActivity(choosePlayer);
                    }
                });

        buttonMultiplePlayer.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        spinner.performClick();
                        //textView.setText(spinner.getSelectedItem().toString());

                        //Intent choosePlayer = new Intent();
                        //choosePlayer.setClass(MainActivity.this, ChoosePlayer.class);
                        //Bundle bundle = new Bundle();
                        //bundle.putInt("playerNumber", Integer.valueOf(spinner.getSelectedItem().toString()));
                        //choosePlayer.putExtras(bundle);
                        //startActivity(choosePlayer);

                    }
                });


        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                //Bundle bundle = new Bundle();
                bundle.putInt("playerNumber",spinner.getSelectedItemPosition());
                choosePlayer.putExtras(bundle);
                startActivity(choosePlayer);
                textView.setText(spinner.getSelectedItem().toString());
                Toast.makeText(MainActivity.this, "您選擇"+spinner.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "您沒有選擇任何項目", Toast.LENGTH_LONG).show();
            }
        });
    }
}
