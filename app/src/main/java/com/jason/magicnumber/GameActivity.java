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
    private int magicNumber;
    private TextView currentNumberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initNewGame();
    }

    public void initNewGame() {
        firstButton = (Button) findViewById(R.id.first_button);
        secondButton = (Button) findViewById(R.id.second_button);
        currentNumberTextView = (TextView) findViewById(R.id.current_number);

        magicNumber = getIntent().getIntExtra(MAGIC_NUMBER, 0);
        TextView magicNumberTextView = (TextView) findViewById(R.id.magic_number);

        magicNumberTextView.setText(String.valueOf(magicNumber));
    }

    public void chooseNextNumber(View view) {
        Button clickedButton = (Button)view;
        String buttonText = clickedButton.getText().toString();
        int chosenNumber = Integer.parseInt(buttonText);

        currentNumberTextView.setText(String.valueOf(chosenNumber));

        if (chosenNumber < magicNumber) {

        }
    }


//    TextView magicNumberTextView = (TextView) findViewById()

}
