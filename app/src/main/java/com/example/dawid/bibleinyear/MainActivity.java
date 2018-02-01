package com.example.dawid.bibleinyear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Calendar calendar = Calendar.getInstance();
        int currentDayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        int currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        calendar.set(Calendar.DAY_OF_YEAR,1);
        int startYearDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        int numberOfChapters = howManyChapters(currentDayOfYear,currentDayOfWeek,startYearDayOfWeek);

        tvDayOfYear.setText(currentDayOfYear+"");
        tvNumberOfChapters.setText(numberOfChapters+"");
    }

    @BindView(R.id.dayOfYear)
    TextView tvDayOfYear;
    @BindView(R.id.numberOfChapters)
    TextView tvNumberOfChapters;

    private int howManyChapters(int currentDayOfYear,int currentDayOfWeek, int startYearDayOfWeek){
        int CHAPTERS_USUAL = 3;
        int CHAPTERS_EXTRA_IN_SUNDAY = 2;

        int result = currentDayOfYear*CHAPTERS_USUAL;
        int numberOfSundays = howManySundays(currentDayOfYear,currentDayOfWeek,startYearDayOfWeek);

        result += numberOfSundays*CHAPTERS_EXTRA_IN_SUNDAY;
        return result;
    }

    private int howManySundays(int currentDayOfYear,int currentDayOfWeek, int startYearDayOfWeek){
        int numberOfSundays;

        if (startYearDayOfWeek == Calendar.SUNDAY || currentDayOfWeek == Calendar.SUNDAY){
            numberOfSundays = currentDayOfYear/7 + 1;
        }
        else numberOfSundays= currentDayOfYear/7;
        return  numberOfSundays;
    }

}
