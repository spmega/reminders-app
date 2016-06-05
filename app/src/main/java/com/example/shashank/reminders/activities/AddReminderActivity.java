package com.example.shashank.reminders.activities;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ListView;

import com.example.shashank.reminders.R;

import java.util.ArrayList;

public class AddReminderActivity extends AppCompatActivity {

    CheckedTextView[] checkBoxDays = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_reminder);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CheckedTextView[] checkBoxToSelectDays = {(CheckedTextView) findViewById(R.id.checkbox_monday),
                (CheckedTextView) findViewById(R.id.checkbox_tuesday),
                (CheckedTextView) findViewById(R.id.checkbox_wednesday),
                (CheckedTextView) findViewById(R.id.checkbox_thursday),
                (CheckedTextView) findViewById(R.id.checkbox_friday),
                (CheckedTextView) findViewById(R.id.checkbox_saturday),
                (CheckedTextView) findViewById(R.id.checkbox_sunday)};
        checkBoxDays = checkBoxToSelectDays;
        checkBoxToSelectDays = null;

        setUpButtons();
        setUpSelectDayCheckBoxes();
    }

    private void setUpSelectDayCheckBoxes() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v instanceof CheckedTextView){
                    if(!((CheckedTextView) v).isChecked())
                        ((CheckedTextView) v).setChecked(true);
                    else
                        ((CheckedTextView) v).setChecked(false);
                }
            }
        };

        for(int i = 0; i < checkBoxDays.length; i++){
            checkBoxDays[i].setOnClickListener(onClickListener);
        }
    }

    private void setUpButtons() {
        findViewById(R.id.cancel_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent data  = new Intent();
                        setResult(RESULT_CANCELED, data);
                        finish();
                    }
                });

        findViewById(R.id.save_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AppCompatEditText titleEdit = (AppCompatEditText) findViewById(R.id.edit_title);
                        AppCompatEditText messageEdit = (AppCompatEditText) findViewById(R.id.edit_message);
                        boolean[] daysSelected = getDaysSlected();

                        Intent data  = new Intent();

                        data.putExtra("Title", titleEdit.getText().toString());
                        data.putExtra("Message", messageEdit.getText().toString());
                        data.putExtra("Selected Days", daysSelected);
                        setResult(RESULT_OK, data);
                        finish();
                    }
                });
    }

    private boolean[] getDaysSlected() {
        boolean[] daysOfWeekSelected = new boolean[7];
        for(int i = 0; i < checkBoxDays.length; i++){
            daysOfWeekSelected[i] = checkBoxDays[i].isChecked();
        }

        return daysOfWeekSelected;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            case R.id.action_settings:
                return true;
            case R.id.add_reminder:
                Intent intent = new Intent();

                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
