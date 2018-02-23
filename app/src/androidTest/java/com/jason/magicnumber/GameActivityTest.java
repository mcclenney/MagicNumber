package com.jason.magicnumber;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class GameActivityTest {

    public static final Integer TEST_MAGIC_NUMBER = 7;

    @Rule
    public ActivityTestRule<GameActivity> rule = new ActivityTestRule<GameActivity>(GameActivity.class){
        @Override
        protected Intent getActivityIntent() {
            InstrumentationRegistry.getTargetContext();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.putExtra(GameActivity.MAGIC_NUMBER, TEST_MAGIC_NUMBER);
            return intent;
        }
    };

    @Test
    public void shouldInitializeMagicNumberOnStart() {
        GameActivity gameActivity = rule.getActivity();

        TextView magicNumberTextView = gameActivity.findViewById(R.id.magic_number);
        Integer magicNumber = Integer.parseInt(magicNumberTextView.getText().toString());
        assertEquals(TEST_MAGIC_NUMBER, magicNumber);
    }

}