package com.example.dawid.bibleinyear;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dawid on 02.02.2018.
 */

public class BookInBible {
    public BookInBible(String name, int numberOfChapter) {
        this.name = name;
        this.numberOfChapter = numberOfChapter;
        chapters = new ArrayList<>();

        for (int i = 0; i<numberOfChapter;i++)
        {
            chapters.add(new Chapter(i));
        }
    }

    private String name;
    private int numberOfChapter;
    public ArrayList<Chapter> chapters;


    public String getName() {
        return name;
    }

    public int getNumberOfChapter() {
        return numberOfChapter;
    }
}
