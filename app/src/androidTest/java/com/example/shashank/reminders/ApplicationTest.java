package com.example.shashank.reminders;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.example.shashank.reminders.activities.Reminders;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    private Application app = null;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        createApplication();
        app = getApplication();
    }

    @Test
    public void saveTest(){
        String title = "Test Title";
        String message = "The is a test message";

        Reminders reminders = new Reminders(title, message);
        reminders.save();

        Reminders savedReminders = Reminders.getOneByTitle(title);

        Assert.assertEquals(title, savedReminders.title);
        Assert.assertEquals(message, savedReminders.message);
    }

}