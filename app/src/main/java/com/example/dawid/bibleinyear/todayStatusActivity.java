package com.example.dawid.bibleinyear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class todayStatusActivity extends AppCompatActivity {

    int numberOfChapters;
    Bible bible = new Bible();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_status);
        ButterKnife.bind(this);


    }

    private void changeTvStatus(){

        int currentLoopsChapter = 0;

        for (int i = 0;i<bible.books.size();i++){
            for (int j = 0;j<bible.books.get(i).getNumberOfChapter();j++){
//                bible.books.get(i).chapters.get(j);
                currentLoopsChapter++;
                if (currentLoopsChapter==numberOfChapters){
                    tvStatus.setText(bible.books.get(i).getName() + " rozdział " + (j+1));
                }
            }
        }
    }

    @OnClick(R.id.btn1) void add1(){
        addNumber(1);
        changeTvStatus();
    }
    @OnClick(R.id.btn2) void add3(){
        addNumber(3);
        changeTvStatus();
    }
    @OnClick(R.id.btn3) void add5(){
        addNumber(5);
        changeTvStatus();

    }

    private void addNumber(int number){
        numberOfChapters += number;
    }

    @BindView(R.id.today_status)
    TextView tvStatus;

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
}
