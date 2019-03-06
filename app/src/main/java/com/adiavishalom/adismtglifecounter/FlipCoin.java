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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip_coin);

        coin = findViewById(R.id.coinView);
        result = findViewById(R.id.result);
        flip = findViewById(R.id.flip);


        flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomNumber = rng.nextInt(2) + 1;
                flipCoin(randomNumber);

            }
        });
    }
    private void flipCoin(int randomNumber)
    {
        if (randomNumber == 1)
        {
            coin.setImageResource(R.drawable.coin_head);
            result.setText("HEADS!");
        }
        else
        {
            coin.setImageResource(R.drawable.coin_tail);
            result.setText("TAILS!");
        }

        return;

    }
}
