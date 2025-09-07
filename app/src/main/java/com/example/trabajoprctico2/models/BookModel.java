package com.example.trabajoprctico2.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class BookModel implements Serializable {
    private String title;
    private String author;
    private int pagesQuantity;
    private int publishYear;
    private ArrayList<String> genres;
    private String description;
    public BookModel(
            String title,
            String author,
            int pagesQuantity,
            int publishYear,
            ArrayList<String> genres,
            String description
    ) {
        this.title = title;
        this.author = author;
        this.pagesQuantity = pagesQuantity;
        this.publishYear = publishYear;
        this.genres = genres;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPagesQuantity() {
        return pagesQuantity;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public String getDescription() {
        return description;
    }
}
