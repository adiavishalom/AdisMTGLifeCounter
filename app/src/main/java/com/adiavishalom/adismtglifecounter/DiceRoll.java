package com.adiavishalom.adismtglifecounter;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class DiceRoll extends AppCompatActivity {

    private ImageView imageViewDice;
    private Random rng = new Random();
    private Button reset;
    private TextView textView;
    private int one= 0, two= 0, three= 0, four= 0, five= 0, six = 0, total = 0;
    double oneStat = 0;
    double twoStat= 0;
    double threeStat= 0;
    double fourStat= 0;
    double fiveStat= 0;
    double sixStat= 0;
    private EditText editText;
    private Button multiButton;
    private Button statistics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Times 1 was rolled: " + one + "\nTimes 2 was rolled: " + two + "\nTimes 3 was rolled: " + three +"\nTimes 4 was rolled: " + four +
                "\nTimes 5 was rolled: " + five +"\nTimes 6 was rolled: " + six + "\nTotal Rolls: " + total);
        imageViewDice = findViewById(R.id.image_view_dice);
        reset = findViewById(R.id.reset);
        multiButton = findViewById(R.id.multiButton);
        editText = findViewById(R.id.editText);
        statistics = findViewById(R.id.statistics);



        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one= 0;
                two= 0;
                three= 0;
                four= 0;
                five= 0;
                six = 0;
                total = 0;
                textView.setText("Times 1 was rolled: " + one + "\nTimes 2 was rolled: " + two + "\nTimes 3 was rolled: " + three +"\nTimes 4 was rolled: " + four +
                        "\nTimes 5 was rolled: " + five +"\nTimes 6 was rolled: " + six + "\nTotal Rolls: " + total);
            }



        });

        multiButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    int count = Integer.parseInt(editText.getText().toString());
                    while (count > 0) {
                        int randomNumber = rng.nextInt(6) + 1;
                        rollDice(randomNumber);
                        textView.setText("Times 1 was rolled: " + one + "\nTimes 2 was rolled: " + two + "\nTimes 3 was rolled: " + three + "\nTimes 4 was rolled: " + four +
                                "\nTimes 5 was rolled: " + five + "\nTimes 6 was rolled: " + six + "\nTotal Rolls: " + total);
                        count--;

                    } //END While
                }
                catch (Exception e) {
                    int randomNumber = rng.nextInt(6) + 1;
                    rollDice(randomNumber);
                    textView.setText("Times 1 was rolled: " + one + "\nTimes 2 was rolled: " + two + "\nTimes 3 was rolled: " + three + "\nTimes 4 was rolled: " + four +
                            "\nTimes 5 was rolled: " + five + "\nTimes 6 was rolled: " + six + "\nTotal Rolls: " + total);

//                    AlertDialog.Builder builder = new AlertDialog.Builder(DiceRoll.this);
//
//                    builder.setCancelable(true);
//                    builder.setTitle("Error");
//                    builder.setMessage("Please provide a number.");
//
//                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.cancel();
//                        }
//                    });
//                    builder.show();
                }


            }//END on click
        });

        statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    oneStat = (100.0*one)/total;
                    twoStat= (100.0*two)/total;
                    threeStat= (100.0*three)/total;
                    fourStat= (100.0*four)/total;
                    fiveStat= (100.0*five)/total;
                    sixStat= (100.0*six)/total;
                }
                catch (Exception e) {
                    oneStat = 0.00;
                    twoStat= 0.00;
                    threeStat= 0.00;
                    fourStat= 0.00;
                    fiveStat= 0.00;
                    sixStat= 0.00;
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(DiceRoll.this);

                builder.setCancelable(true);
                builder.setTitle("Statistics:");
                builder.setMessage("One was rolled:\t" + oneStat + "%" + "\nTwo was rolled:\t" + twoStat + "%" + "\nThree was rolled:\t" + threeStat + "%" + "\nFour was rolled:\t" +
                        fourStat + "%" +"\nFive was rolled:\t" + fiveStat + "%"  + "\nSix was rolled:\t" + sixStat + "%");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });

    }

    private void rollDice(int randomNumber){


        switch (randomNumber) {
            case 1:
                imageViewDice.setImageResource(R.drawable.dice1);
                this.one++;
                break;
            case 2:
                imageViewDice.setImageResource(R.drawable.dice2);
                this.two++;
                break;
            case 3:
                imageViewDice.setImageResource(R.drawable.dice3);
                this.three++;
                break;
            case 4:
                imageViewDice.setImageResource(R.drawable.dice4);
                this.four++;
                break;
            case 5:
                imageViewDice.setImageResource(R.drawable.dice5);
                this.five++;
                break;
            case 6:
                imageViewDice.setImageResource(R.drawable.dice6);
                this.six++;
                break;

        }
        total++;

    }
}

