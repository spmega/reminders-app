package com.example.shashank.reminders.activities;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

/**
 * Created by shashank on 6/4/16.
 */
public class RemindersApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Configuration dbConfiguration = new Configuration.Builder(this)
                .setDatabaseName("Reminders_app.db")
                .addModelClass(Reminders.class)
                .setDatabaseVersion(2)
                .create();
        ActiveAndroid.initialize(dbConfiguration);
    }
}
