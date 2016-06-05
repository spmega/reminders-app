package com.example.shashank.reminders.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.example.shashank.reminders.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by shashank on 5/28/16.
 */
public class RemindersListAdapter extends ArrayAdapter<Reminders> {

    public RemindersListAdapter(Context context, ArrayList<Reminders> reminders) {
        super(context, 0, reminders);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Reminders reminder = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.list_title);
        TextView message = (TextView) convertView.findViewById(R.id.message);
        CheckedTextView[] daysSelected = {(CheckedTextView) convertView.findViewById(R.id.list_item_sunday),
                (CheckedTextView) convertView.findViewById(R.id.list_item_monday),
                (CheckedTextView) convertView.findViewById(R.id.list_item_tuesday),
                (CheckedTextView) convertView.findViewById(R.id.list_item_wednesday),
                (CheckedTextView) convertView.findViewById(R.id.list_item_thursday),
                (CheckedTextView) convertView.findViewById(R.id.list_item_friday),
                (CheckedTextView) convertView.findViewById(R.id.list_item_saturday)
        };

        title.setText(reminder.title);
        message.setText(reminder.message);
        for(int i = 0; i < daysSelected.length; i++){
            daysSelected[i].setChecked(reminder.daysOfWeekSelected[i]);
        }

        return convertView;
    }
}
