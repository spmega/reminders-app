package com.example.shashank.reminders;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.AppCompatEditText;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.shashank.reminders.activities.MainActivity;
import com.example.shashank.reminders.activities.Reminders;
import com.example.shashank.reminders.activities.RemindersListAdapter;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by shashank on 6/2/16.
 */
@SmallTest
@RunWith(AndroidJUnit4.class)
public class RemoveReminderTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    String title = "Title";
    String message = "njdsvbjasd dsn vjla vhasd vhjad vdja ";

    @Test
    public void test_removeReminder(){
        //// TODO: 6/4/16 Must complete UI Automation test for deleting a reminder 

    }

}
