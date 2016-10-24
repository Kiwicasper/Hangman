package com.example.kiwic.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    Button restart;

    Intent game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ImageView image = (ImageView) findViewById(R.id.img_result);

        Intent i = getIntent();
        if (i.getExtras().getBoolean("result")){
            image.setImageResource(R.mipmap.won);
        }
        else {
            image.setImageResource(R.mipmap.lost);
        }

        restart = (Button) findViewById(R.id.btn_restart);
        restart.setOnClickListener(this);

        game = new Intent(this, GameActivity.class);

    }

    @Override
    public void onClick(View v) {
        this.startActivity(game);

    }
}
