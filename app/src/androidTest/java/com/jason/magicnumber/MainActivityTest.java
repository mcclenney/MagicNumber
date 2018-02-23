package com.jason.magicnumber;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void onStartNewGameNumberEntryShouldBeBlank() {
        MainActivity activity = rule.getActivity();
        TextView newGameNumberTextView = activity.findViewById(R.id.new_game_number);
        assertThat(newGameNumberTextView.getText().toString(), isEmptyString());
    }
}