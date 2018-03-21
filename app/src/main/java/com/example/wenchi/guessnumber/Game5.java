package com.example.wenchi.guessnumber;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;

/**
 * Created by Eva on 2017/6/13.
 */

public class Game5 extends AppCompatActivity {
    private Intent intent = new Intent();
    private Bundle bundle = new Bundle();
    private ImageView flag1,flag2,flag3,flag4,flag5;
    private ImageView player1Icon, player2Icon,player3Icon,player4Icon,player5Icon;
    private TextView player1Name, player2Name,player3Name,player4Name,player5Name;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game5);

        intent = this.getIntent();
        bundle = this.getIntent().getExtras();

        playerName = bundle.getStringArray("name");

        icon = bundle.getIntArray("icon");
        playerNumber = icon[0];


        //setID
        player1Icon = (ImageView) findViewById(R.id.player1Icon);
        player1Name = (TextView) findViewById(R.id.player1Name);
        flag1 = (ImageView) findViewById(R.id.flag1);

        player2Icon = (ImageView)findViewById(R.id.player2Icon);
        player2Name = (TextView)findViewById(R.id.player2Name);
        flag2 = (ImageView) findViewById(R.id.flag2);

        player3Icon = (ImageView)findViewById(R.id.player3Icon);
        player3Name = (TextView)findViewById(R.id.player3Name);
        flag3 = (ImageView) findViewById(R.id.flag3);

        player4Icon = (ImageView)findViewById(R.id.player4Icon);
        player4Name = (TextView)findViewById(R.id.player4Name);
        flag4 = (ImageView) findViewById(R.id.flag4);

        player5Icon = (ImageView)findViewById(R.id.player5Icon);
        player5Name = (TextView)findViewById(R.id.player5Name);
        flag5 = (ImageView) findViewById(R.id.flag5);

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

        flag2.setVisibility(View.GONE);
        flag3.setVisibility(View.GONE);
        flag4.setVisibility(View.GONE);
        flag5.setVisibility(View.GONE);
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
                intent.setClass(Game5.this, Win.class);
                bundle.putStringArray("name", playerName);
                bundle.putIntArray("icon", icon);

                if(flag1.getVisibility()==View.VISIBLE){
                    bundle.putInt("winImage", image[icon[1]]);
                    bundle.putString("winName", String.valueOf(playerName[0]));
                }
                else if(flag2.getVisibility()==View.VISIBLE){
                    bundle.putInt("winImage", image[icon[2]]);
                    bundle.putString("winName", String.valueOf(playerName[1]));
                }
                else if(flag3.getVisibility()==View.VISIBLE){
                    bundle.putInt("winImage", image[icon[3]]);
                    bundle.putString("winName", String.valueOf(playerName[2]));
                }
                else if(flag4.getVisibility()==View.VISIBLE){
                    bundle.putInt("winImage", image[icon[4]]);
                    bundle.putString("winName", String.valueOf(playerName[3]));
                }
                else if(flag5.getVisibility()==View.VISIBLE){
                    bundle.putInt("winImage", image[icon[5]]);
                    bundle.putString("winName", String.valueOf(playerName[4]));
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
                else if(flag2.getVisibility()==View.VISIBLE){
                    flag2.setVisibility(View.GONE);
                    flag3.setVisibility(View.VISIBLE);
                }
                else if(flag3.getVisibility()==View.VISIBLE){
                    flag3.setVisibility(View.GONE);
                    flag4.setVisibility(View.VISIBLE);
                }
                else if(flag4.getVisibility()==View.VISIBLE){
                    flag4.setVisibility(View.GONE);
                    flag5.setVisibility(View.VISIBLE);
                }
                else if(flag5.getVisibility()==View.VISIBLE){
                    flag5.setVisibility(View.GONE);
                    flag1.setVisibility(View.VISIBLE);
                }
            }
            else if(count == 0){
                Toast.makeText(getApplicationContext(),"請喊三個數!!", Toast.LENGTH_SHORT).show();
            }
            count = 0;
        }
    };

    public void setIcon(int[] icon,String[] playerName){
        player1Icon.setImageResource(image[icon[1]]);
        player1Name.setText(playerName[0]);
        player2Icon.setImageResource(image[icon[2]]);
        player2Name.setText(playerName[1]);

            player3Icon.setImageResource(image[icon[3]]);
            player3Name.setText(playerName[2]);


            player4Icon.setImageResource(image[icon[4]]);
            player4Name.setText(playerName[3]);

                player5Icon.setImageResource(image[icon[5]]);
                player5Name.setText(playerName[4]);

    }
}
