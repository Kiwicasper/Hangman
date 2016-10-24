package com.example.kiwic.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    Button start;
    Intent game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        game = new Intent(this, GameActivity.class);

        start = (Button) findViewById(R.id.btn_start);
        start.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        this.startActivity(game);
    }
}
