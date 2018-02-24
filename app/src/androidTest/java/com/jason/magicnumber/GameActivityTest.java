package com.jason.magicnumber;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

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
        onView(withId(R.id.magic_number))
                .check(matches(withText(String.valueOf(TEST_MAGIC_NUMBER))));
    }

    @Test
    public void shouldInitializeFirstTwoButtonsOnStart() {
        onView(withId(R.id.first_button))
                .check(matches(withText("1")));
        onView(withId(R.id.second_button))
                .check(matches(withText("2")));
    }

    @Test
    public void shouldUpdateButtonsAfterSelection() {
        onView(withId(R.id.first_button))
                .perform(ViewActions.click());

        onView(withId(R.id.first_button))
                .check(matches(withText("2")));
        onView(withId(R.id.second_button))
                .check(matches(withText("3")));
    }

    @Test
    public void shouldDisplayOnlyLastButton(){
        for (int i=0; i<TEST_MAGIC_NUMBER-1; i++) {
            onView(withId(R.id.first_button))
                    .perform(ViewActions.click());
        }
        onView(withId(R.id.first_button))
                .check(matches(isDisplayed()));
        onView(withId(R.id.second_button))
                .check(matches(not(isDisplayed())));
    }
}