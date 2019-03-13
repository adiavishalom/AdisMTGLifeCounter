package com.adiavishalom.adismtglifecounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;


public class MainActivity
        extends AppCompatActivity
        implements TokenDialog.TokenDialogListener{

    private Button newGame;
    private Button rollDice;
    private Button flipCoin;

    private NumberPicker player1life;
    private NumberPicker player2life;
    //private TextView player1History;
    //private TextView player2History;
    private Button player1FiveUp;
    private Button player1OneUp;
    private Button player1OneDown;
    private Button player1FiveDown;
    private Button player2FiveUp;
    private Button player2OneUp;
    private Button player2OneDown;
    private Button player2FiveDown;
    private ImageView player1PoisonLeft, player1PoisonRight, player2PoisonLeft, player2PoisonRight;
    private TextView player1Poison, player2Poison;
    private ImageView player1CommanderLeft, player1CommanderRight, player2CommanderLeft, player2CommanderRight;
    private TextView player1Commander, player2Commander;
    private TextView player1TokenCount, player1TokenStats;
    private Button player1TokenChange, player1TokenOneUp, player1TokenOneDown;
    private ImageView tokenImage1;
    private int player1TokenCountNumber;
    public int playerNumber;
    private TextView player2TokenCount, player2TokenStats;
    private Button player2TokenChange, player2TokenOneUp, player2TokenOneDown;
    private ImageView tokenImage2;
    private int player2TokenCountNumber;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newGame = findViewById(R.id.newGame);
        rollDice = findViewById(R.id.diceRollButton);
        flipCoin = findViewById(R.id.coinFlipButton);

        player1life = findViewById(R.id.player1life);
        player2life = findViewById(R.id.player2life);
        //player1History = findViewById(R.id.player1History);
        //player2History = findViewById(R.id.player2History);

        player1FiveUp = findViewById(R.id.player1FiveUp);
        player1OneUp = findViewById(R.id.player1OneUp);
        player1OneDown = findViewById(R.id.player1OneDown);
        player1FiveDown = findViewById(R.id.player1FiveDown);

        player2FiveUp = findViewById(R.id.player2FiveUp);
        player2OneUp = findViewById(R.id.player2OneUp);
        player2OneDown = findViewById(R.id.player2OneDown);
        player2FiveDown = findViewById(R.id.player2FiveDown);

        player1life.setMinValue(0);
        player1life.setMaxValue(99);
        //player1life.setRotation(180);
        player1life.setWrapSelectorWheel(true);
        player1life.setValue(40);

        player2life.setMinValue(0);
        player2life.setMaxValue(99);
        player2life.setWrapSelectorWheel(true);
        player2life.setValue(40);


        player1Poison = findViewById(R.id.player1Poison);
        player1Poison.setText("0");
        player2Poison = findViewById(R.id.player2Poison);
        player2Poison.setText("0");
        player1PoisonLeft = findViewById(R.id.player1PoisonLeft);
        player1PoisonRight = findViewById(R.id.player1PoisonRight);
        player2PoisonLeft = findViewById(R.id.player2PoisonLeft);
        player2PoisonRight = findViewById(R.id.player2PoisonRight);

        player1Commander = findViewById(R.id.player1Commander);
        player1Commander.setText("0");
        player2Commander = findViewById(R.id.player2Commander);
        player2Commander.setText("0");
        player1CommanderLeft = findViewById(R.id.player1CommanderLeft);
        player1CommanderRight = findViewById(R.id.player1CommanderRight);
        player2CommanderLeft = findViewById(R.id.player2CommanderLeft);
        player2CommanderRight = findViewById(R.id.player2CommanderRight);

        player1TokenCount = findViewById(R.id.player1TokenCount);
        player1TokenCountNumber = 0;
        player1TokenStats = findViewById(R.id.player1TokenStats);
        player1TokenChange= findViewById(R.id.player1TokenChange);
        tokenImage1 = findViewById(R.id.tokenImage1);
        tokenImage1.setImageResource(R.drawable.token_goblin);
        player1TokenOneUp= findViewById(R.id.player1TokenOneUp);
        player1TokenOneDown=findViewById(R.id.player1TokenOneDown);

        player2TokenCount = findViewById(R.id.player2TokenCount);
        player2TokenCountNumber = 0;
        player2TokenStats = findViewById(R.id.player2TokenStats);
        player2TokenChange= findViewById(R.id.player2TokenChange);
        tokenImage2 = findViewById(R.id.tokenImage2);
        tokenImage2.setImageResource(R.drawable.token_goblin);
        player2TokenOneUp= findViewById(R.id.player2TokenOneUp);
        player2TokenOneDown=findViewById(R.id.player2TokenOneDown);



        //New Game Button
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                player1life.setValue(40);
                player2life.setValue(40);
                player1Poison.setText("0");
                player2Poison.setText("0");
                player1Commander.setText("0");
                player2Commander.setText("0");
                player1TokenCount.setText("0x");
                player1TokenStats.setText("0/0");
            }
        });



        //PLAYER 1 BUTTONS START
        //Life Counter Start
        player1FiveUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int health = player1life.getValue()+5;
                player1life.setValue(health);
            }
        });
        player1OneUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int health = player1life.getValue()+1;
                player1life.setValue(health);
            }
        });
        player1OneDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int health = player1life.getValue()-1;
                player1life.setValue(health);
            }
        });
        player1FiveDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int health = player1life.getValue()-5;
                player1life.setValue(health);
            }
        });
        //Life Counter End
        //Poison Counter Start
        player1PoisonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = Integer.parseInt(player1Poison.getText().toString())-1;
                counter = CounterCheck(counter, 10, 0);
                player1Poison.setText(Integer.toString(counter));
            }
        });
        player1PoisonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = Integer.parseInt(player1Poison.getText().toString())+1;
                counter = CounterCheck(counter, 10, 0);
                player1Poison.setText(Integer.toString(counter));
            }
        });

        //Poison Counter End
        //Commander Damage Start
        player1CommanderLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = Integer.parseInt(player1Commander.getText().toString())-1;
                counter = CounterCheck(counter, 21, 0);
                player1Commander.setText(Integer.toString(counter));
            }
        });
        player1CommanderRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = Integer.parseInt(player1Commander.getText().toString())+1;
                counter = CounterCheck(counter, 21, 0);
                player1Commander.setText(Integer.toString(counter));
            }
        });

        //Commander Damage End
        //Token Buttons Start
        player1TokenChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerNumber = 1;
                openTokenOptions();
            }
        });

        player1TokenOneUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1TokenCountNumber = CounterCheck(player1TokenCountNumber+1, 99, 0);
                player1TokenCount.setText((player1TokenCountNumber) + "x");
            }
        });

        player1TokenOneDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1TokenCountNumber = CounterCheck(player1TokenCountNumber-1, 99, 0);
                player1TokenCount.setText((player1TokenCountNumber) + "x");
            }
        });
        //PLAYER 1 BUTTONS END



        //PLAYER 2 BUTTONS START
        //Life Counter Start
        player2FiveUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int health = player2life.getValue()+5;
                player2life.setValue(health);
            }
        });
        player2OneUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int health = player2life.getValue()+1;
                player2life.setValue(health);
            }
        });
        player2OneDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int health = player2life.getValue()-1;
                player2life.setValue(health);
            }
        });
        player2FiveDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int health = player2life.getValue()-5;
                player2life.setValue(health);
            }
        });
        //Life Counter End

        //Poison Counter Start
        player2PoisonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = Integer.parseInt(player2Poison.getText().toString())-1;
                counter = CounterCheck(counter, 10, 0);
                player2Poison.setText(Integer.toString(counter));
            }
        });
        player2PoisonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = Integer.parseInt(player2Poison.getText().toString())+1;
                counter = CounterCheck(counter, 10, 0);
                player2Poison.setText(Integer.toString(counter));
            }
        });

        //Poison Counter End
        //Commander Damage Start
        player2CommanderLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = Integer.parseInt(player2Commander.getText().toString())-1;
                counter = CounterCheck(counter, 21, 0);
                player2Commander.setText(Integer.toString(counter));
            }
        });
        player2CommanderRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = Integer.parseInt(player2Commander.getText().toString())+1;
                counter = CounterCheck(counter, 21, 0);
                player2Commander.setText(Integer.toString(counter));
            }
        });

        //Commander Damage End
        //Token Buttons Start
        player2TokenChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerNumber = 2;
                openTokenOptions();
            }
        });

        player2TokenOneUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player2TokenCountNumber = CounterCheck(player2TokenCountNumber+1, 99, 0);
                player2TokenCount.setText((player2TokenCountNumber) + "x");
            }
        });

        player2TokenOneDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player2TokenCountNumber = CounterCheck(player2TokenCountNumber-1, 99, 0);
                player2TokenCount.setText((player2TokenCountNumber) + "x");
            }
        });
        //PLAYER 2 BUTTONS END

        //CHANGE ACTIVITY BUTTONS

        rollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DiceRoll.class));
            }
        });

        flipCoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FlipCoin.class));
            }
        });







        /*
        player1life.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String history1 = Integer.toString(newVal);
                history1 = history1 + "\n";
                player1History.append(history1);
            }
        });

        player2life.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String history2 = Integer.toString(newVal);
                history2 = history2 + "\n";
                player2History.append(history2);
            }
        });
        */

    }

    private int CounterCheck(int count, int max, int min)     //Makes sure that the counters don't go over 10
    {
        if (count < min)
        {
            return min;
        }
        if (count > max)
        {
            return max;
        }
        return count;
    }

    public void openTokenOptions()
    {
        TokenDialog tokenDialog = new TokenDialog();
        tokenDialog.show(getSupportFragmentManager(), "token dialog");
    }

    @Override
    public void applyGenerate(int amount, int power, int toughness)
    {
//        int gained = amount-player1TokenCountNumber;
//        if (player1TokenCountNumber<amount)
//        {
//            tokenHistory.setText("You gained " + gained + " tokens");
//        }
//        if (player1TokenCountNumber>amount)
//        {
//            tokenHistory.setText("You lost " + gained + " tokens");
//        }
        if (playerNumber == 1){
            player1TokenStats.setText(power+"/"+toughness);
            player1TokenCount.setText(amount + "x");
            player1TokenCountNumber = amount;
        }
        else if (playerNumber == 2){
            player2TokenStats.setText(power+"/"+toughness);
            player2TokenCount.setText(amount + "x");
            player2TokenCountNumber = amount;
            
        }
//        textViewTokens.setText("You have, " + power + "/" + toughness + " tokens x" + amount);
    }


}

