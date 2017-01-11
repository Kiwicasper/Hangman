package com.example.kiwic.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import logik.Galgelogik;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    Button restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ImageView image = (ImageView) findViewById(R.id.img_result);
        TextView text = (TextView) findViewById(R.id.correctWord);

        Intent i = getIntent();
        if (i.getExtras().getBoolean("result")){
            text.setText("Du gættede ordet: " + i.getExtras().getString("ord"));
            image.setImageResource(R.mipmap.won);
        }
        else {
            text.setText("Du kunne ikke gætte ordet: " + i.getExtras().getString("ord"));
            image.setImageResource(R.mipmap.lost);
        }

        restart = (Button) findViewById(R.id.btn_restart);
        restart.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        this.finish();

    }
}
