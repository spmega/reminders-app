package com.example.shashank.reminders;

import android.app.IntentService;
import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.ListView;

import org.junit.Assert;

import com.example.shashank.reminders.activities.AddReminderActivity;
import com.example.shashank.reminders.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
/**
 * Created by shashank on 5/30/16.
 */


@RunWith(AndroidJUnit4.class)
@SmallTest
public class AddReminderApplicationTest {

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void test_addReminder(){
        int numOfSavedBeforeTest = 0;
        int numOfSavedAfterTest = 0;

        ListView listView = (ListView) mMainActivityRule.getActivity().findViewById(R.id.reminders_list);

        numOfSavedBeforeTest = listView.getAdapter().getCount();

        //launch the activity
        Intent intent = new Intent(mMainActivityRule.getActivity(), AddReminderActivity.class);
        mMainActivityRule.getActivity().startActivityForResult(intent, mMainActivityRule.getActivity().REQUEST_CODE);

        //set a title
        Espresso.onView(ViewMatchers.withId(R.id.edit_title)).perform(ViewActions.typeText("Testing the editTexts"));
        //set the message
        Espresso.onView(ViewMatchers.withId(R.id.edit_message)).perform(ViewActions.typeText("Testing the editTexts, and this is the message."));
        //click the save button
        Espresso.onView(ViewMatchers.withId(R.id.save_button)).perform(ViewActions.click());

        numOfSavedAfterTest = listView.getAdapter().getCount();

        Assert.assertNotEquals(numOfSavedBeforeTest, numOfSavedAfterTest);
        Assert.assertEquals(numOfSavedBeforeTest, 0);
        Assert.assertEquals(numOfSavedAfterTest, 1);
    }
}
