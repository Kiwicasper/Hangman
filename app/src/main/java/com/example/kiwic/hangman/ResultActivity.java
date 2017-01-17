package com.example.kiwic.hangman;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    Button restart;

    TextView previusLost;
    TextView previusWon;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ImageView image = (ImageView) findViewById(R.id.img_result);
        TextView text = (TextView) findViewById(R.id.correctWord);

        previusLost = (TextView) findViewById(R.id.previusLost);
        previusWon = (TextView) findViewById(R.id.previusWon);


        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        Intent i = getIntent();
        if (i.getExtras().getBoolean("result")){
            text.setText("Du gættede ordet: " + i.getExtras().getString("ord"));
            image.setImageResource(R.mipmap.won);
            sharedPreferences.edit().putInt("won", (sharedPreferences.getInt("won", 0)+1)).commit();
            update();

        }
        else {
            text.setText("Du kunne ikke gætte ordet: " + i.getExtras().getString("ord"));
            image.setImageResource(R.mipmap.lost);
            sharedPreferences.edit().putInt("lost", (sharedPreferences.getInt("lost", 0)+1)).commit();
            update();
        }




        restart = (Button) findViewById(R.id.btn_restart);
        restart.setOnClickListener(this);

    }

    private void update() {

        previusLost.setText("Du har i alt vundet " + sharedPreferences.getInt("won", 0) + " gange");
        previusWon.setText("Du har i alt tabt " + sharedPreferences.getInt("lost", 0) + " gange");
    }

    @Override
    public void onClick(View v) {
        this.startActivity(new Intent(this, WordListActivity.class));
        this.finish();

    }
}
