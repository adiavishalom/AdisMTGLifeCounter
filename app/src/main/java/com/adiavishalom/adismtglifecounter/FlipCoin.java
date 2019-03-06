package com.adiavishalom.adismtglifecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class FlipCoin extends AppCompatActivity {
    private ImageView coin;
    private TextView result;
    private Button flip;
    private Random rng = new Random();
    private boolean flipped = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip_coin);

        coin = findViewById(R.id.coinView);
        result = findViewById(R.id.result);
        flip = findViewById(R.id.flip);
        coin.setVisibility(View.INVISIBLE);



        flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomNumber = rng.nextInt(2) + 1;
                flipCoin(randomNumber);
            }
        });
    }
    private void flipCoin(int randomNumber)
    {                                                                   //////////////////////////////////////////////////////////////////////
        if(flipped)                                                     //If flipped is true, then the button is currently set to reset     //
        {                                                               //                                                                  //
            flip.setText("Flip Coin");                                  //Button becomes Flip Coin again                                    //
            coin.setVisibility(View.INVISIBLE);                         //the coin image disappears                                         //
            result.setText("");                                         //result is cleared                                                 //
            flipped = false;                                            //flipped is now false                                              //
        }                                                               //////////////////////////////////////////////////////////////////////
        else                                                            //If flipped is false, then the button is currently set to Flip Coin//
        {                                                           //                                                                  //
            if (randomNumber == 1)                                  //if rng=1,                                                         //
            {                                                       //                                                                  //
                coin.setImageResource(R.drawable.coin_head);        //make image Heads                                                  //
                result.setText("HEADS!");                           //display Heads                                                     //
            }                                                       //                                                                  //
            else                                                    //rng can only equal 1 or 2, so if its not 1,                       //
            {                                                       //                                                                  //
                coin.setImageResource(R.drawable.coin_tail);        //make image Tails                                                  //
                result.setText("TAILS!");                           //display Tails                                                     //
            }                                                       //                                                                  //
            coin.setVisibility(View.VISIBLE);                       //make the coin image appear showing that the coin is flipped       //
            flip.setText("Reset");                                  //button becomes reset                                              //
            flipped = true;                                         //not the status of the coin is flipped                             //
        }                                                           //////////////////////////////////////////////////////////////////////


        return;

    }
}
