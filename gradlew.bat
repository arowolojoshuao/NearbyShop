package ng.com.silveredgeprojects.mmo.utilities.helper;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by Matthew on 4/18/2017.
 */

public class DateTimePicker implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    private Context context;
    private Calendar calendar;
    private onCalendarSet calendarDelegate;
    private onClockSet clockDelegate;
    private DatePickerDialog dpd;

    public DateTimePicker(Context context, onCalendarSet calendarDelegate, onClockSet clockDelegate) {
        this.context = context;
        this.calendarDelegate = calendarDelegate;
        this.clockDelegate = clockDelegate;
        init();
    }

    private void init() {
        calendar = Calendar.getInstance(Locale.getDefault());
        dpd = DatePickerDialog.newInstance(this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        dpd.setOnCancelListener(dialogInterface -> calendarDelegate.cancel());
    }

    public DateTimePicker setTitle(String title) {
        dpd.setTitle(title);
        return this;
    }

    public void showCalendar(boolean setMinDate) {

        if (setMinDate) {
            dpd.setMinDate(Calendar.getInstance(Locale.getDefault()));
        }
        dpd.vibrate(false);
        dpd.show(((AppCompatActivity) context).getFragmentManager(), "DatePicker");
    }

    public void showClock() {
        TimePickerDialog tpd = TimePickerDialog.newInstance(this,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND),
                false);
        tpd.vibrate(false);
        tpd.show(((AppCompatActivity) context).getFragmentManager(), "TimePicker");
    }

    private Date dateToDateObj(int year, int monthOfYear, int dayOfMonth) {
        GregorianCalendar calendar = new GregorianCalendar();
        calen