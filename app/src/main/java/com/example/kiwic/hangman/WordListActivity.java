package com.example.kiwic.hangman;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import logik.Galgelogik;

public class WordListActivity extends AppCompatActivity {

    ListView listView;
    String[] words;

    ArrayAdapter adapter;

    Galgelogik logik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);
        words = new String[20];

        logik = Galgelogik.getIntance();

        Toast.makeText(this, "Loader ord", Toast.LENGTH_LONG);

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
                adapter.notifyDataSetChanged();

            }
        }.execute();

        listView = (ListView) findViewById(R.id.list_view);




        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 , words);
        listView.setAdapter(adapter);

    }
}
