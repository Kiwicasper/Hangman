package com.example.kiwic.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import logik.Galgelogik;

public class WordListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayList<String> words;

    Intent game;

    ArrayAdapter adapter;

    Galgelogik logik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);
        words = new ArrayList<String>();

        logik = Galgelogik.getIntance();

        game = new Intent(this, GameActivity.class);

        words = logik.getList();

        listView = (ListView) findViewById(R.id.list_view);

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 , words);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        logik.pickWord(words.get(position));
        this.startActivity(game);
        finish();
    }
}
