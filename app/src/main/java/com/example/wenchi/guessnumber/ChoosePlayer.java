package com.example.wenchi.guessnumber;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;

public class ChoosePlayer extends AppCompatActivity {

    private ImageButton player1Icon, player2Icon, player3Icon, player4Icon, player5Icon;
    private EditText player1Name, player2Name, player3Name, player4Name, player5Name;
    private TextView textView1, textView2, textView3, textView4, textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_player);

        Intent intent = this.getIntent();
        Bundle bundle = this.getIntent().getExtras();
        int playerNumber = bundle.getInt("playerNumber");

        player1Icon = (ImageButton)findViewById(R.id.player1Icon);
        player1Name = (EditText)findViewById(R.id.player1Name);
        textView1 = (TextView)findViewById(R.id.textView1);

        player2Icon = (ImageButton)findViewById(R.id.player2Icon);
        player2Name = (EditText)findViewById(R.id.player2Name);
        textView2 = (TextView)findViewById(R.id.textView2);

        player3Icon = (ImageButton)findViewById(R.id.player3Icon);
        player3Name = (EditText)findViewById(R.id.player3Name);
        textView3 = (TextView)findViewById(R.id.textView3);

        player4Icon = (ImageButton)findViewById(R.id.player4Icon);
        player4Name = (EditText)findViewById(R.id.player4Name);
        textView4 = (TextView)findViewById(R.id.textView4);

        player5Icon = (ImageButton)findViewById(R.id.player5Icon);
        player5Name = (EditText)findViewById(R.id.player5Name);
        textView5 = (TextView)findViewById(R.id.textView5);


        if(playerNumber == 1){
            textView1.setText("電腦");
            textView2.setText("玩家");

            textView3.setVisibility(View.GONE);
            player3Icon.setVisibility(View.GONE);
            player3Name.setVisibility(View.GONE);
            textView4.setVisibility(View.GONE);
            player4Icon.setVisibility(View.GONE);
            player4Name.setVisibility(View.GONE);
            textView5.setVisibility(View.GONE);
            player5Icon.setVisibility(View.GONE);
            player5Name.setVisibility(View.GONE);
        }
        else if(playerNumber == 2){
            textView3.setVisibility(View.GONE);
            player3Icon.setVisibility(View.GONE);
            player3Name.setVisibility(View.GONE);
            textView4.setVisibility(View.GONE);
            player4Icon.setVisibility(View.GONE);
            player4Name.setVisibility(View.GONE);
            textView5.setVisibility(View.GONE);
            player5Icon.setVisibility(View.GONE);
            player5Name.setVisibility(View.GONE);
        }
        else if(playerNumber == 3){
            textView4.setVisibility(View.GONE);
            player4Icon.setVisibility(View.GONE);
            player4Name.setVisibility(View.GONE);
            textView5.setVisibility(View.GONE);
            player5Icon.setVisibility(View.GONE);
            player5Name.setVisibility(View.GONE);
        }
        else if(playerNumber == 4){
            textView5.setVisibility(View.GONE);
            player5Icon.setVisibility(View.GONE);
            player5Name.setVisibility(View.GONE);
        }
    }
}
