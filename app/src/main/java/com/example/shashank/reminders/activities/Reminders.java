package com.example.shashank.reminders.activities;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

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

    public Reminders(){
        super();
    }

    public Reminders(String title, String message){
        super();
        this.title = title;
        this.message = message;
    }

    public static List<Reminders> getAll(){
        return new Select()
                .from(Reminders.class)
                .orderBy("Name ABC")
                .limit(100)
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
