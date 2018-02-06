package com.example.dawid.bibleinyear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

        //int numberOfChapters = howManyChapters(currentDayOfYear,currentDayOfWeek,startYearDayOfWeek);
        int numberOfChapters = whichChapter(currentDayOfYear,startYearDayOfWeek);
        tvDayOfYear.setText("Mija właśnie " +currentDayOfYear+" dzień twojego postanowienia");
        tvNumberOfChapters.setText(currentStatus(numberOfChapters));
    }

    @BindView(R.id.dayOfYear)
    TextView tvDayOfYear;
    @BindView(R.id.numberOfChapters)
    TextView tvNumberOfChapters;
    @BindView(R.id.button_today_status_activity)
    Button btnGoTo2Activity;

    @OnClick(R.id.button_today_status_activity) void goTo(){
        Intent intent = new Intent(MainActivity.this,todayStatusActivity.class);
        startActivity(intent);
    }

    private String currentStatus(int numberOfChapters){
        Bible bible = new Bible();
        int previousChapters = 0;
        String currentBook = "";
        int currentChapter = 0;

        for (int i=0; i<bible.books.size(); i++){

            if (previousChapters >= numberOfChapters){
                return currentBook+ " rozdział " + currentChapter;
            }
            else {
                currentChapter = numberOfChapters - previousChapters;
                currentBook = bible.books.get(i).getName();

                previousChapters += bible.books.get(i).getNumberOfChapter();
            }
        }
        return "błąd";
    }

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

        numberOfSundays = currentDayOfYear/7;
        if (startYearDayOfWeek == Calendar.SUNDAY){
            numberOfSundays += 1;
        }
        if (currentDayOfWeek == Calendar.SUNDAY){
            numberOfSundays += 1;
        }

        return  numberOfSundays;
    }

    private int whichChapter(int currentDayOfYear, int startYearDayOfWeek){
        int firstWeek =  Calendar.SUNDAY - (startYearDayOfWeek - 1);
        int numberOfChapterFirstWeek = 0;
        if (firstWeek != 0){
            numberOfChapterFirstWeek = firstWeek * 3 + 2;
        }
        int daysLeft = currentDayOfYear - firstWeek;

        int numberOfChaptersFullWeek = (daysLeft/7)*(7*3+2);

        int numberOfChaptersLeft = (daysLeft%7)*3;

        int result = numberOfChapterFirstWeek+numberOfChaptersFullWeek+numberOfChaptersLeft;
        return result;
    }

}
