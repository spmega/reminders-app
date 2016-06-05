package com.example.shashank.reminders.activities;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shashank on 5/28/16.
 */
@Table(name = "Reminders")
public class Reminders extends Model {

    @Column(name = "Title", index = true)
    public String title = null;

    @Column(name = "Message")
    public String message = null;

    //TODO: must serialize, SQLDatabase or ActiveAndroid ORM cannot store arrays
    @Column(name = "Days")
    public boolean[] daysOfWeekSelected = new boolean[7];

    public Reminders(){
        super();
    }

    public Reminders(String title, String message, boolean[] daysOfWeekSelected){
        super();
        this.title = title;
        this.message = message;
        this.daysOfWeekSelected = daysOfWeekSelected;
    }

    public static List<Reminders> getAll(){
        return new Select()
                .from(Reminders.class)
                .execute();
    }

    public static Reminders getOneByTitle(String title){
        return (Reminders) new Select()
                .from(Reminders.class)
                .orderBy("Name ABC")
                .where("Reminders = ?", title)
                .executeSingle();
    }
}
