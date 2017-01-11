package com.example.kiwic.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import logik.Galgelogik;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    TextView word, letters;
    Button btnGuess;
    EditText txtGuess;
    ImageView image;
    Galgelogik logik;
    Intent result;
    ArrayList<String> guessed = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);

        logik = Galgelogik.getIntance();

        word = (TextView) findViewById(R.id.word);
        btnGuess = (Button) findViewById(R.id.btn_guess);
        txtGuess = (EditText) findViewById(R.id.txt_guess);
        image = (ImageView) findViewById(R.id.img_gallows);
        letters = (TextView) findViewById(R.id.txt_guessedLetters);

        word.setText(logik.getSynligtOrd());



        btnGuess.setOnClickListener(this);
        result = new Intent(this, ResultActivity.class);

    }

    private void restart(){
        logik.nulstil();

        finish();
    }

    @Override
    public void onClick(View v) {
        if (txtGuess.getText().length() !=1){
            txtGuess.setText("");
            txtGuess.setHint("One letter at a time");
        }
        else {
            guessed.add(txtGuess.getText().toString());
            String s = "gættede bogstaver: ";
            for (int i = 0; i < guessed.size(); i++){
                s = s + guessed.get(i) + " ";
            }
            letters.setText(s);
            logik.gætBogstav(txtGuess.getText().toString());
            word.setText(logik.getSynligtOrd());

            if (logik.erSidsteBogstavKorrekt()) {
                if (logik.erSpilletVundet()) {
                    result.putExtra("result", true);
                    result.putExtra("ord", logik.getOrdet());
                    restart();
                    this.startActivity(result);
                }
            } else {
                if(logik.erSpilletTabt()){
                    result.putExtra("result", false);
                    result.putExtra("ord", logik.getOrdet());
                    restart();
                    this.startActivity(result);
                }
                else {

                    switch (logik.getAntalForkerteBogstaver()) {
                        case 1:
                            image.setImageResource(R.mipmap.wrong1);
                            break;
                        case 2:
                            image.setImageResource(R.mipmap.wrong2);
                            break;
                        case 3:
                            image.setImageResource(R.mipmap.wrong3);
                            break;
                        case 4:
                            image.setImageResource(R.mipmap.wrong4);
                            break;
                        case 5:
                            image.setImageResource(R.mipmap.wrong5);
                            break;
                        case 6:
                            image.setImageResource(R.mipmap.wrong6);
                            break;
                    }
                }


            }
        }
        txtGuess.setText("");


    }
}
