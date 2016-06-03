package com.example.shashank.reminders;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;

import com.example.shashank.reminders.activities.AddReminderActivity;
import com.example.shashank.reminders.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by shashank on 5/30/16.
 */


@RunWith(AndroidJUnit4.class)
@SmallTest
public class SampleApplicationTest {

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void test_menuButton(){
        Espresso.onView(ViewMatchers.withId(R.id.add_reminder)).perform(ViewActions.click());
    }
}
