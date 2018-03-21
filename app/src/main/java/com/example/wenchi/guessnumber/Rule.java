package com.example.wenchi.guessnumber;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Eva on 2017/6/6.
 */

public class Rule extends AppCompatActivity {
    private TextView textView6;
    private Button button;
    private Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rule);
        intent = this.getIntent();

        textView6 = (TextView)findViewById(R.id.textView6);
        button = (Button)findViewById(R.id.button);
        textView6.setText("◆此遊戲為多人遊戲 \n\n◆目標數字的範圍在20~100且為隨機 \n\n◆每次輪到的人可以往上加1~3個數字 \n\n◆最後喊到目標數字者獲勝");

        button.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        intent.setClass(Rule.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
    }
}
