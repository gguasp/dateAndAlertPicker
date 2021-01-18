package com.example.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

    private int mYear, mMonth, mDay, mHour, mMinute;
    Button btnDatePicker, btnTimePicker, btnAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTimePicker = (Button) findViewById(R.id.timeButton);
        btnTimePicker.setOnClickListener(this);

        btnDatePicker = (Button) findViewById(R.id.dateButton);
        btnDatePicker.setOnClickListener(this);

        btnAlert = (Button) findViewById(R.id.alertButton);
        btnAlert.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            Toast.makeText(getApplicationContext(),dayOfMonth + "-" + (monthOfYear + 1) + "-" + year, Toast.LENGTH_LONG).show();

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnTimePicker) {

            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            Toast.makeText(getApplicationContext(),hourOfDay + ":" + minute, Toast.LENGTH_LONG).show();
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
        if (v == btnAlert) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder
                    .setTitle("Alert")
                    .setMessage("click OK to continue or Cancel to stop: ")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //Yes button clicked, do something
                            Toast.makeText(getApplicationContext(), "Yes button pressed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancel", null)                      //Do nothing on no
                    .show();
        }
    }
}