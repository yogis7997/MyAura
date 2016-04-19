package com.seraphicinfosolutions.myaura.Utils;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by seraphicinfosolutions on 4/13/16.
 */
public class Utility {

    private final int hour, minute;
    private Context context;
    private Calendar cal;
    private int day;
    private int month;
    private int year;
    private DateListener dateListener;

    public Utility(Context context) {
        this.context = context;
        cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);
        hour = cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE);
    }

    public String getCurrentDate() {
        return parseDateToddMMyyyy(day + "/" + (month + 1) + "/" + year);
    }

    public String getCurrentTime(){
        return updateTime(hour,minute);
    }

    public interface DateListener {
        public void onDateSelected(String date);
    }

    public void DateDialog(final TextView dateListener) {


        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dateListener.setText(parseDateToddMMyyyy(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year));

//                dateListener.setText(dayOfWeek);
            }
        };

        DatePickerDialog dpDialog = new DatePickerDialog(context, listener, year, month, day);
        dpDialog.show();

    }


    public void timeDialog(final TextView dateListener) {

        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                dateListener.setText(updateTime(selectedHour, selectedMinute));
            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }

    public String parseDateToddMMyyyy(String time) {
        String inputPattern = "dd/MM/yyy";
        String outputPattern = "MMM, EEE dd yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }


    private String updateTime(int hours, int mins) {

        String timeSet = "";
        if (hours > 12) {
            hours -= 12;
            timeSet = "PM";
        } else if (hours == 0) {
            hours += 12;
            timeSet = "AM";
        } else if (hours == 12)
            timeSet = "PM";
        else
            timeSet = "AM";


        String minutes = "";
        if (mins < 10)
            minutes = "0" + mins;
        else
            minutes = String.valueOf(mins);

        // Append in a StringBuilder
        String aTime = new StringBuilder().append(hours).append(':')
                .append(minutes).append(" ").append(timeSet).toString();

        return aTime;
    }

public void Share(){
    Intent sendIntent = new Intent();
    sendIntent.setAction(Intent.ACTION_SEND);
    sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
    sendIntent.setType("text/plain");
    context.startActivity(sendIntent);
}
}
