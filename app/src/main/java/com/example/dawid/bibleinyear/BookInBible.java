package com.example.dawid.bibleinyear;

/**
 * Created by Dawid on 02.02.2018.
 */

public class BookInBible {
    public BookInBible(String name, int numberOfChapter) {
        this.name = name;
        this.numberOfChapter = numberOfChapter;
    }

    private String name;
    private int numberOfChapter;

    public String getName() {
        return name;
    }

    public int getNumberOfChapter() {
        return numberOfChapter;
    }
}
