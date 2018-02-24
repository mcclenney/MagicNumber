package com.jason.magicnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    public static final String MAGIC_NUMBER = "magic_number";

    private Button firstButton;
    private Button secondButton;
    private Button playAgainButton;
    private int magicNumber;
    private TextView currentNumberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initNewGame();
    }

    public void initNewGame() {
        firstButton = findViewById(R.id.first_button);
        secondButton = findViewById(R.id.second_button);
        playAgainButton = findViewById(R.id.play_again_button);
        currentNumberTextView = findViewById(R.id.current_number);

        magicNumber = getIntent().getIntExtra(MAGIC_NUMBER, 0);
        TextView magicNumberTextView = findViewById(R.id.magic_number);

        magicNumberTextView.setText(String.valueOf(magicNumber));
    }

    public void chooseNextNumber(View view) {
        Button clickedButton = (Button)view;
        String buttonText = clickedButton.getText().toString();
        int chosenNumber = Integer.parseInt(buttonText);

        currentNumberTextView.setText(String.valueOf(chosenNumber));

        if (chosenNumber < magicNumber) {
            firstButton.setText(Integer.toString(chosenNumber+1));
            if (chosenNumber < magicNumber-1) {
                secondButton.setText(Integer.toString(chosenNumber+2));
            }
            else {
                secondButton.setVisibility(View.INVISIBLE);
            }
        }
        else {
            firstButton.setVisibility(View.INVISIBLE);
            secondButton.setVisibility(View.INVISIBLE);
            playAgainButton.setVisibility(View.VISIBLE);
        }
    }

    public void playAgain(View view) {
        finish();
    }
}
