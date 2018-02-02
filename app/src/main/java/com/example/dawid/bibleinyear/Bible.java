package com.example.dawid.bibleinyear;

import java.util.ArrayList;

public class Bible{
    public ArrayList<BookInBible> books;
    private String version;

    public Bible() {
        version = "Biblia Warszawska";
        books = new ArrayList<>();

        books.add(new BookInBible("I Księga Mojżeszowa",50));
        books.add(new BookInBible("II Księga Mojżeszowa",40));
        books.add(new BookInBible("III Księga Mojżeszowa",27));
        books.add(new BookInBible("IV Księga Mojżeszowa",36));
        books.add(new BookInBible("V Księga Mojżeszowa",34));

        books.add(new BookInBible("Księga Jozuego",24));
        books.add(new BookInBible("Księga Sędziów",21));
        books.add(new BookInBible("Księga Rut",4));

        books.add(new BookInBible("I Księga Samuela",31));
        books.add(new BookInBible("II Księga Samuela",24));
        books.add(new BookInBible("I Księga Królewska",22));
        books.add(new BookInBible("II Księga Królewska",25));
        books.add(new BookInBible("I Księga Kronik",29));
        books.add(new BookInBible("I Księga Kronik",36));

        books.add(new BookInBible("Księga Ezdrasza",10));
        books.add(new BookInBible("Księga Nehemiasza",13));
        books.add(new BookInBible("Księga Estery",10));
        books.add(new BookInBible("Księga Joba",42));

        books.add(new BookInBible("Księga Psalmów",150));
        books.add(new BookInBible("Przypowieści Salomona",31));
        books.add(new BookInBible("Księga Kaznodziei Salomona",12));
        books.add(new BookInBible("Pieśni nad Pieśniami",8));

        books.add(new BookInBible("Księga Izajasza",66));
        books.add(new BookInBible("Księga Jeremiasza",52));
        books.add(new BookInBible("Treny",5));
        books.add(new BookInBible("Księga Ezechiela",48));
        books.add(new BookInBible("Księga Daniela",12));

        books.add(new BookInBible("Księga Ozeasza",14));
        books.add(new BookInBible("Księga Joela",3));
        books.add(new BookInBible("Księga Amosa",9));
        books.add(new BookInBible("Księga Abdiasza",1));
        books.add(new BookInBible("Księga Jonasza",4));
        books.add(new BookInBible("Księga Micheasza",7));

        books.add(new BookInBible("Księga Nahuma",3));
        books.add(new BookInBible("Księga Habakuka",3));
        books.add(new BookInBible("Księga Sofoniasza",3));
        books.add(new BookInBible("Księga Aggeusza",2));
        books.add(new BookInBible("Księga Zachariasza",14));
        books.add(new BookInBible("Księga Malachiasza",3));
    }
}