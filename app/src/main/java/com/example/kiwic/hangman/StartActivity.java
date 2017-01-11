package com.example.kiwic.hangman;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import logik.Galgelogik;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    Button start;
    Intent wordList;
    Galgelogik logik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        logik = Galgelogik.getIntance();

        wordList = new Intent(this, WordListActivity.class);

        start = (Button) findViewById(R.id.btn_start);
        start.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] params) {
                try {
                    logik.hentOrd();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                startNextActivity();


            }
        }.execute();


    }

    private void startNextActivity() {

        this.startActivity(wordList);
    }

}
