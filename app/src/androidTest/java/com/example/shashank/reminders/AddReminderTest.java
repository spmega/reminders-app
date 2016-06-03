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

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by shashank on 6/2/16.
 */
@SmallTest
@RunWith(AndroidJUnit4.class)
public class AddReminderTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void test_addReminder(){
        ListView listView = (ListView) mActivityRule.getActivity()
                .findViewById(R.id.reminders_list);

        ListAdapter listAdapter = listView.getAdapter();

        int beforeTest = listAdapter.getCount();

        Espresso.onView(ViewMatchers.withId(R.id.add_reminder)).perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.edit_title)).perform(ViewActions.typeText("Testing Title"));
        Espresso.onView(ViewMatchers.withId(R.id.edit_message)).perform(ViewActions.typeText("Testing Title and writing stuff in message"));
        Espresso.onView(ViewMatchers.withId(R.id.save_button)).perform(ViewActions.click());

        int aferTest = listAdapter.getCount();

        Assert.assertNotEquals(beforeTest, aferTest);
        Assert.assertEquals(beforeTest, 0);
        Assert.assertEquals(aferTest, 1);

    }

    @Test
    public void test_removeReminder(){
        ListView listView = (ListView) mActivityRule.getActivity()
                .findViewById(R.id.reminders_list);

        ListAdapter listAdapter = listView.getAdapter();

        int beforeTest = listAdapter.getCount();

        Espresso.onView(ViewMatchers.withId(R.id.add_reminder)).perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.edit_title)).perform(ViewActions.typeText("Testing Title"));
        Espresso.onView(ViewMatchers.withId(R.id.edit_message)).perform(ViewActions.typeText("Testing Title and writing stuff in message"));
        Espresso.onView(ViewMatchers.withId(R.id.save_button)).perform(ViewActions.click());

        Espresso.onData(ViewMatchers.withText("Testing Title")).perform(ViewActions.longClick());
    }

}
