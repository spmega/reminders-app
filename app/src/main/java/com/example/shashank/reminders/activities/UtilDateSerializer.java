package com.example.shashank.reminders.activities;

import com.activeandroid.serializer.TypeSerializer;

import java.util.Calendar;

/**
 * Created by shashank on 6/5/16.
 */
public class UtilDateSerializer extends TypeSerializer{

    //TODO: serialize Calender object in Reminders to Long

    @Override
    public Object deserialize(Object data) {
        return null;
    }

    @Override
    public Class<?> getDeserializedType() {
        return Calendar.class;
    }

    @Override
    public Class<?> getSerializedType() {
        return Long.class;
    }

    @Override
    public Object serialize(Object data) {
        return null;
    }
}
