package com.example.wenchi.guessnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;

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
    }
}
