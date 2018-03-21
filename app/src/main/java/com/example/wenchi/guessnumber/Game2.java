package com.example.wenchi.guessnumber;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;

/**
 * Created by Eva on 2017/6/6.
 */

public class Game2 extends AppCompatActivity{
    private Intent intent = new Intent();
    private Bundle bundle = new Bundle();
    private ImageView flag1,flag2,flag3,flag4,flag5;
    private ImageView player1Icon, player2Icon,player3Icon, player4Icon,player5Icon;
    private TextView player1Name, player2Name,player3Name, player4Name,player5Name;
    private TextView answerTextView, currentNumberTextView;
    private Button minus, plus, ok;
    private int playerNumber=0;
    private int[] image = {R.drawable.cat, R.drawable.plant, R.drawable.rabbit};

    private SecureRandom random = new SecureRandom();
    private int answer, computerCount, computerNumber;
    private int count = 0;
    private int currentNumber = 0;
    private int[] icon = new int[3];
    private String[] playerName = {};

    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = this.getIntent();
        bundle = this.getIntent().getExtras();

        playerName = bundle.getStringArray("name");
        icon = bundle.getIntArray("icon");
        playerNumber = icon[0];


        setContentView(R.layout.game2);


        //setID
        player1Icon = (ImageView) findViewById(R.id.player1Icon);
        player1Name = (TextView) findViewById(R.id.player1Name);
        flag1 = (ImageView) findViewById(R.id.flag1);

        player2Icon = (ImageView)findViewById(R.id.player2Icon);
        player2Name = (TextView)findViewById(R.id.player2Name);
        flag2 = (ImageView) findViewById(R.id.flag2);

        answerTextView = (TextView)findViewById(R.id.answerTextView);
        currentNumberTextView = (TextView)findViewById(R.id.currentNumberTextView);
        minus = (Button)findViewById(R.id.minus);
        plus = (Button)findViewById(R.id.plus);
        ok = (Button)findViewById(R.id.ok);

        setIcon(icon,playerName);


        answer = random.nextInt(80)+20;
        answer=10;
        answerTextView.setText(String.valueOf(answer));

        minus.setOnClickListener(buttonMinus);
        plus.setOnClickListener(buttonPlus);
        ok.setOnClickListener(buttonOK);

        flag2.setVisibility(View.INVISIBLE);
    }

    private Button.OnClickListener buttonMinus = new Button.OnClickListener(){
        @Override
        public void onClick(View v){
            if(count <= 3 && count > 1){
                count--;
                currentNumber--;
                currentNumberTextView.setText(String.valueOf(currentNumber));
            }
            if(count <= 1){
                Toast.makeText(getApplicationContext(),"最少一個數!!", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private Button.OnClickListener buttonPlus = new Button.OnClickListener(){
        @Override
        public void onClick(View v){
            if(count < 3 && count >= 0 && currentNumber < answer){
                count++;
                currentNumber++;
                currentNumberTextView.setText(String.valueOf(currentNumber));
            }
            else if(count >= 3){
                Toast.makeText(getApplicationContext(),"最多三個數!!", Toast.LENGTH_SHORT).show();
            }
            if(currentNumber==answer){
                intent.setClass(Game2.this, Win.class);
                bundle.putStringArray("name", playerName);
                bundle.putIntArray("icon", icon);
                if(playerNumber==1) {
                    bundle.putInt("winImage", image[icon[2]]);
                    bundle.putString("winName", String.valueOf(playerName[1]));
                }
                else{
                    if(flag1.getVisibility()==View.VISIBLE){
                        bundle.putInt("winImage", image[icon[1]]);
                        bundle.putString("winName", String.valueOf(playerName[0]));
                    }
                    else if(flag2.getVisibility()==View.VISIBLE){
                        bundle.putInt("winImage", image[icon[2]]);
                        bundle.putString("winName", String.valueOf(playerName[1]));
                    }
                }
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
    };

    private Button.OnClickListener buttonOK = new Button.OnClickListener(){
        @Override
        public void onClick(View v){
            if (count > 0){
                //旗子移動，換下一位玩家
                if(flag1.getVisibility()==View.VISIBLE){
                    flag1.setVisibility(View.GONE);
                    flag2.setVisibility(View.VISIBLE);
                }
                else{
                    flag2.setVisibility(View.GONE);
                    flag1.setVisibility(View.VISIBLE);
                }
                if(playerNumber == 1){
                    if(currentNumber < answer && flag2.getVisibility()==View.VISIBLE){
                        if((answer-currentNumber)<=3){
                            computerCount=answer-currentNumber;
                        }
                        else if((answer-currentNumber)==5){
                            computerCount=1;
                        }
                        else if((answer-currentNumber)==6){
                            computerCount=2;
                        }
                        else if((answer-currentNumber)==7){
                            computerCount=3;
                        }
                        else{
                            computerCount = random.nextInt(3)+1;
                        }
                        computerNumber=0;
                        handler.postDelayed(computer, 500);
                    }
                }
            }
            else if(count == 0){
                Toast.makeText(getApplicationContext(),"請喊三個數!!", Toast.LENGTH_SHORT).show();
            }
            count = 0;
        }
    };

    public void setIcon(int[] icon,String[] playerName) {
        if (playerNumber == 1) {
            player1Icon.setImageResource(image[icon[2]]);
            player1Name.setText(playerName[1]);
            player2Icon.setImageResource(image[icon[1]]);
            player2Name.setText(playerName[0]);
        }
        else {
            player1Icon.setImageResource(image[icon[1]]);
            player1Name.setText(playerName[0]);
            player2Icon.setImageResource(image[icon[2]]);
            player2Name.setText(playerName[1]);
        }
    };


    private Runnable computer = new Runnable() {
        public void run() {
            computerNumber++;
            currentNumber++;
            currentNumberTextView.setText(String.valueOf(currentNumber));
            handler.postDelayed(this, 500);
            if(computerNumber == computerCount){
                handler.removeCallbacks(computer);
                if(currentNumber!=answer){
                    flag2.setVisibility(View.GONE);
                    flag1.setVisibility(View.VISIBLE);
                }
                else{
                    intent.setClass(Game2.this, Win.class);
                    bundle.putStringArray("name", playerName);
                    bundle.putIntArray("icon", icon);
                    bundle.putInt("winImage", image[icon[1]]);
                    bundle.putString("winName", String.valueOf(player2Name.getText()));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        }
    };

}
