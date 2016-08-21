package com.example.shouritou.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TimePicker timePicker;
    private DatePicker datePicker;
    private Calendar cal;
    private int year1;
    private int month;
    private int day;
    private int hour;
    private String minute1;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取日历的一个对象
        cal = Calendar.getInstance();
        //获得年月日时分秒的信息
        year1 = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
        hour = cal.get(Calendar.HOUR_OF_DAY);
        minute1 = String.valueOf(cal.get(Calendar.MINUTE));
        setTitle(year1 + "-" + month + "-" + day + "-" + hour + ":" + minute1);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        button=(Button)findViewById(R.id.btn_cer);
        //datePicker初始化
        datePicker.init(year1, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                setTitle(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                year1=year;
                month=monthOfYear;
                day=dayOfMonth;
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//                setTitle(hourOfDay + ":" + minute);
                hour=hourOfDay;
                if (minute<=9)
                minute1="0"+String.valueOf(minute);
                else
                    minute1=String.valueOf(minute);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTitle(year1 + "-" + month + "-" + day + "-" + hour + ":" + minute1);
            }
        });
    }
}
