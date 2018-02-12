package com.jason.magicnumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String MAGIC_NUMBER = "magic_number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startNewGame(View view) {
        Intent gameIntent = new Intent(this, GameActivity.class);

        TextView newGameNumberTextView =
                (TextView) findViewById(R.id.new_game_number);

        String newGame = newGameNumberTextView.getText().toString();

        int newGameNumber = Integer.parseInt(newGameNumberTextView.getText().toString());

        gameIntent.putExtra(MAGIC_NUMBER, newGameNumber);

        startActivity(gameIntent);
    }

}
